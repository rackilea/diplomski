HConnection connection;
    HTableInterface hTableInterface = null;

    Configuration hBaseConfig = HBaseConfiguration.create();
    hBaseConfig.setInt("timeout", 120000);
    //zookeeper quorum, basic info needed to proceed
    hBaseConfig.set("hbase.zookeeper.quorum","host1, host2, host3");
    hBaseConfig.set("hbase.zookeeper.property.clientPort", "2181");
    hBaseConfig.set("zookeeper.znode.parent", "/hbase-unsecure");
    connection = HConnectionManager.createConnection(hBaseConfig);
    hTableInterface = connection.getTable(TableName.valueOf("amarTest"));

    try {   
        Put put = new Put(Bytes.toBytes("999"));
        put.add(Bytes.toBytes("cf"),Bytes.toBytes("name"), Bytes.toBytes("amar"));
        hTableInterface.put(put);
        System.out.println("done");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        hTableInterface.close();
        connection.close();
    }