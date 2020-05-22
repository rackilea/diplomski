byte[] rowKey = Bytes.toBytes("allen_test_row");
    Put put = new Put(rowKey);
    put.add(ColumnFamilyName, QName1, 1000, Bytes.toBytes("a"));
    put.add(ColumnFamilyName, QName1, 2000, Bytes.toBytes("b"));
    table.put(put);

    Get get = new Get(rowKey);
    get.setMaxVersions(10);
    Result result = table.get(get);
    KeyValue[] keyValues = result.raw();
    Assert.assertEquals(2, keyValues.length);
    //have a and b both.
    Assert.assertEquals('a' + 'b', keyValues[0].getValue()[0]
            + keyValues[1].getValue()[0]);