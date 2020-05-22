class GameRecordComparator implements Comparable<Record> {
  @Override
  public int compare(Record r1, Record r2) {
    return r1.getScore() - r2.getScore();
  }
}