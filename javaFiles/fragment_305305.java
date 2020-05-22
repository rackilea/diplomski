void setup() {

  table = loadTable("CVSTEST.csv", "header");
  int rows = table.getRowCount();
  int columns = table.getColumnCount();

  test = new String[rows][columns];