public class DBImporter {

    private final static Logger log = LoggerFactory.getLogger(DBImporter.class);
    private static final List<String> NULL_VALUES = Arrays.asList("", "N.A", "N.A", "UNKNOWN");
    private static final List<String> COL_HEADERS = Arrays.asList("USER_ID", "NAME", "TYPE", "SRC_DATA");
    private static final int BATCH_SIZE = 50;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = IOException.class)
    public void processFile(BufferedReader reader, String tableName) {
        AtomicBoolean eof = new AtomicBoolean(false);
        List<String> sqlBatch = new ArrayList<String>(BATCH_SIZE);

        log.info("Starte auslesen der Daten");
        long t1 = System.currentTimeMillis();
        log.info("Start time: " + t1);

        jdbcTemplate.execute("DELETE FROM " + tableName);

        while (!eof.get()) {
            try {
                Map<String, ColumnData> dbColumns = getDBColumns(tableName);

                // Get a list of db column data related to the column headers.
                List<ColumnData> columnData = COL_HEADERS.stream().map(dbColumns::get).collect(toList());

                // Get the next valid data row if its starts from "R" or "T".
                List<String> dataRow = findNextLineStartingWith(reader, eof, "R", "T");

                String query = createSql(tableName, columnData, dataRow);
                sqlBatch.add(query);

                // Process batch.
                if (sqlBatch.size() >= BATCH_SIZE) {
                    jdbcTemplate.batchUpdate(sqlBatch.toArray(new String[sqlBatch.size()]));
                    sqlBatch.clear();
                }
            } catch (IllegalStateException e) {
                break;
            } catch (IOException e) {
                log.error(e.getLocalizedMessage());
            }
        }

        // Commit the final batch.
        jdbcTemplate.batchUpdate(sqlBatch.toArray(new String[sqlBatch.size()]));
        sqlBatch.clear();

        long delta = System.currentTimeMillis() - t1;
        log.info("Total runtime : " + delta / 1000 + " seconds");
    }

    /**
     * Create a SQL insert query using the data row.
     *
     * @param tableName  Name of the table.
     * @param columnData Column data list.
     * @param dataRow    Data row to be inserted.
     * @return Generated SQL query string.
     */
    private String createSql(String tableName, List<ColumnData> columnData, List<String> dataRow) {
        List<String> values = new ArrayList<>(columnData.size());

        for (int i = 0; i < columnData.size(); i++) {
            if (NULL_VALUES.contains(dataRow.get(i))) {
                values.add("NULL");
            } else if (columnData.get(i).getType() >= Types.NUMERIC && columnData.get(i).getType() <= Types.DOUBLE) {
                values.add(dataRow.get(i));
            } else {
                values.add("'" + dataRow.get(i).replace("'", "''") + "'");
            }
        }

        return "INSERT INTO " + tableName + " (" +
                columnData.stream().filter(Objects::nonNull).map(ColumnData::getName).collect(joining(", ")) +
                ", SYSTEM_INSERTED_AT) VALUES (" +
                values.stream().collect(joining(", ")) +
                ", CURRENT_TIMESTAMP)";
    }

    /**
     * Find the next line starting with the given string and split it into columns.
     *
     * @param reader   BufferedReader object to be used.
     * @param prefixes A list of prefixes to look for in the string.
     * @return List of data objects.
     * @throws IOException
     */
    private List<String> findNextLineStartingWith(BufferedReader reader, AtomicBoolean eof, String... prefixes) throws IOException {
        while (true) {
            String line = readLineOrThrow(reader, eof);
            for (String prefix : prefixes)
                if (line.startsWith(prefix)) {
                    ArrayList<String> data = new ArrayList<>();
                    // Split the line using the delimiter.
                    data.addAll(Arrays.asList(line.split(";")));

                    // Build the row to be inserted.
                    List<String> row = Arrays.asList(data.get(1), data.get(2).trim(), "", "");

                    // Insert type depending on the prefix.
                    if (prefix.equals("R"))
                        row.set(2, "USER");
                    else if (prefix.equals("T"))
                        row.set(2, "PERM");

                    row.set(3, String.join(";", row.subList(0, 3)));

                    return row;
                }
        }
    }

    /**
     * Read a single line in the file.
     *
     * @param reader BufferedReader object to be used.
     * @return
     * @throws IOException
     */
    private String readLineOrThrow(BufferedReader reader, AtomicBoolean eof) throws IOException {
        String line = reader.readLine();
        if (line == null) {
            eof.set(true);
            throw new IllegalStateException("Unexpected EOF");
        }

        return line.trim();
    }

    /**
     * Read database column metadata.
     *
     * @param tableName Name of the table to process.
     * @return A map containing column information.
     */
    private Map<String, ColumnData> getDBColumns(String tableName) {
        Map<String, ColumnData> result = new HashMap<>();
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            ResultSet rs = connection.getMetaData().getColumns(null, null, tableName, null);
            while (rs.next()) {
                String columnName = rs.getString(4).toUpperCase();
                int type = rs.getInt(5);
                result.put(columnName, new ColumnData(columnName, type));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}