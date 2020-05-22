jdbcTemplate.batchUpdate("INSERT INTO TABLEOFNUMBERS(ITEM1, ITEM2) values (:1, :2)",
                new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i ) throws SQLException {
                ps.setString(1, batch.get(i).getITEM1());
                ps.setString(2, batch.get(i).getITEM2());
            }

            public int getBatchSize() {
                return batch.size();
            }
        });