int n = 0;
int numSeries = 100000;
int batchSize = 5000;

while (true) {

  for (int i = 0; i < batchSize; i++) {
    n = (n + 1) % numSeries
    list.add("cpu,atag=test" + n + " idle=100,usertime=10,system=1");
  }

  influxDB.write(dbName, "autogen", InfluxDB.ConsistencyLevel.ALL, list);
  list.clear();
  logger.info("WritePoints for " + 1 + " writes of " + 5000 + " Points took:" + watch);
}