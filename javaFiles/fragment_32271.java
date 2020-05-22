DefaultTable fourColTable = new DefaultTable("4COLUMNTABLE",
            new Column[] { 
                new Column("COL1", DataType.BIGINT),
                new Column("COL2", DataType.BIGINT),
                new Column("COL3", DataType.VARCHAR),
                new Column("COL4", DataType.VARCHAR)
                });
for (int i = 0; i < someVal; i++)
    fourColTable.addRow(new Object[] { list1.get(i), list2.get(i), ..., ... });

DefaultDataSet dds = new DefaultDataSet(fourColTable);