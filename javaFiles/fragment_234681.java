@Override
public void insertAllReportsByHost(Map<String, List<IReport>> hostReports) throws DatabaseException {
    try {
        Cassandra.Client client = getClient();

        Map<ByteBuffer, Map<String, List<Mutation>>> mutationsMap = new HashMap<ByteBuffer, Map<String, List<Mutation>>>();

        for (Map.Entry<String, List<IReport>> entryReport : hostReports.entrySet()) {

            ByteBuffer host = toByteBuffer(entryReport.getKey());
            List<IReport> reports = entryReport.getValue();
            Map<String, List<Mutation>> keyMutations = new HashMap<String, List<Mutation>>();
            List<Mutation> mutations = new ArrayList<Mutation>();

            for (IReport report : reports) {
                report.getProperties();
                Column reportDataColumn = new Column(toByteBuffer("Report Data"));
                reportDataColumn.setValue(toByteBuffer(report.toString()));//TODO make another way
                reportDataColumn.setTimestamp(System.currentTimeMillis());

                Long nano = System.nanoTime();
                SuperColumn superColumn = new SuperColumn(toByteBuffer(report.getReportId().toString()), Arrays.asList(reportDataColumn));
                ColumnOrSuperColumn col = new ColumnOrSuperColumn();
                col.super_column = superColumn;

                Mutation m = new Mutation();
                m.setColumn_or_supercolumn(col);

                mutations.add(m);
            }


            keyMutations.put(COLUMN_FAMILY, mutations);

            mutationsMap.put(host, keyMutations);
        }

        client.batch_mutate(mutationsMap, ConsistencyLevel.ONE);

    } catch (UnsupportedEncodingException e) {
        LOGGER.error(e.getMessage(), e);
        throw new DatabaseException(e);
    } catch (UnavailableException e) {
        LOGGER.error(e.getMessage(), e);
        throw new DatabaseException(e);
    } catch (TException e) {
        LOGGER.error(e.getMessage(), e);
        throw new DatabaseException(e);
    } catch (InvalidRequestException e) {
        LOGGER.error(e.getMessage(), e);
        throw new DatabaseException(e);
    } catch (TimedOutException e) {
        LOGGER.error(e.getMessage(), e);
        throw new DatabaseException(e);
    }
}