long currentDay = currentTimeMS / (1000 * 60 * 60 * 60 * 24);
long yesterday = currentDay - 1;

Scan dayScan = new Scan(); 
dayScan.setStartRow(Bytes.toBytes(yesterday));
dayScan.setStopRow(Bytes.toBytes(currentDay));
// create map reduce job with dayScan