public class SafeRow {
  private final String rowId;
  private String rowIdClient;
  private String name;
  private boolean delete;

  public SafeRow(String name) {
    this();
    this.name = name;
  }

  public SafeRow() {
    rowId = UUID.randomUUID().toString();
  }

  public String getRowId() { return rowId; }    
  public void setRowId(String rowIdClient) { this.rowIdClient = rowIdClient; }

  public boolean isStateConsistent() {
    return rowId.equals(rowIdClient);
  }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public boolean isDelete() { return delete; }
  public void setDelete(boolean delete) { this.delete = delete; }
}