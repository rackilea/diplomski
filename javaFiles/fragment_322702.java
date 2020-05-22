static final String addBatchIdSql = "INSERT INTO batch" + "(description)" + "VALUES (?)";
static final String getBatchIdSql = "SELECT LAST_INSERT_ID() AS id";

@Override
public int getBatchId() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String batchIDcreation = dateFormat.format(new Date());
    jdbcTemplate.update(addBatchIdSql, batchIDcreation);
    SqlRowSet rowSet = jdbcTemplate.queryForRowSet(getBatchIdSql);
    if (rowSet.next()) {
        System.out.println(rowSet.findColumn("id"));
    }
    return 0;
}