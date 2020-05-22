boolean nextResultSet = statement.execute(...);
int resultSetCount = 0;
while (true) {
  if (nextResultSet) {
    resultSetCount++;
    try (ResultSet rs = statement.getResultSet()) {
      // Do something with result set
    }
  } else {
    int updateCount = statement.getUpdateCount();
    if (updateCount == -1) {
      // no more results
      break;
    }
    // do something with update count
  }
  nextResultSet = statement.getMoreResults();
}