public class SafeUpdateBean {
  private final List<SafeRow> data = new ArrayList<SafeRow>();

  public SafeUpdateBean() {
    data.add(new SafeRow("Bill"));
    data.add(new SafeRow("Ben"));
    data.add(new SafeRow("Sue"));
  }

  public List<SafeRow> getData() { return data; }

  public String deleteSelected() {
    Iterator<SafeRow> all = data.iterator();
    while (all.hasNext()) {
      SafeRow row = all.next();
      if (!row.isStateConsistent()) {
        System.err.println("Caught inconsistency on " + row.getRowId());
      } else if (row.isDelete()) {
        all.remove();
      }
    }
    return null;
  }
}