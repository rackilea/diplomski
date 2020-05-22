class DyntableResponse<T> {
  private List<T> records;
  public List<T> getRecords() { return records; }
  public void setRecords(final List<T> records) { this.records = records; }
  public int getQueryRecordCount() { return records.size(); }
  public int getTotalRecordCount() { return records.size(); }
}