BufferedReader reader = ...
int batchSize = 10;
boolean moreLines = true;
while (moreLines) {
  List<String> batch = readBatch(reader, batchSize);
  ... do something with that list
  if (batch.size() < batchSize) {
    moreLines = false;
}