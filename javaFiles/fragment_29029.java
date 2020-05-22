dataset.foreachPartition(new ForeachPartitionFunction<Row>() {
            public void call(Iterator<Row> r) throws Exception {
                while (t.hasNext()){

                    Row row = r.next();
                    System.out.println(row.getString(1));

                }
                // do your business logic and load into MySQL.
            }
        });