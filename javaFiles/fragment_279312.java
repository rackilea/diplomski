private static class DateRow {

    private Date key;
    private String[] rowData;

    public DateRow(String[] rowData, Date key) {
      this.rowData = rowData;
      this.key = key;
    }

    public String[] getData() {
      return this.rowData;
    }

    public Date getKey() {
      return this.key;
    }
}