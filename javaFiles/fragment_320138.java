public class CellularData {
  private Object[][] array; // <- use Object instead of CellularData

  public CellularData(int rows, int column, int year) {
    array = new Object[rows + 1][column + 1]; // <- +1 for the heading line and the country name column

    // write head line to array
    array[0][0] = "Country";
    for (int i = 1; i <= column; i++) {
      array[0][i] = year++;
    }
  }

  public void insert(String country, double[] num) {
    for (int i = 0; i < array.length; i++) {
      if (array[i][0] == null) { // <- search for an empty row to insert the data there
        insert(country, num, i);
        break;
      }
    }
  }

  private void insert(String country, double[] num, int row) {
    array[row][0] = country; // <- write the country to the first column
    for (int j = 1; j < array[row].length; j++) { // <- data starts at the second column
      array[row][j] = num[j - 1]; // <- -1 because the num array is one column shorter than 'array' (due to the country name column in 'array')
    }
  }

  public static void main(String[] args) {
    final double[] canada = { 0, 0, 0.05, 0.23, 0.37, 0.75, 1.26 };
    final double[] mexico = { 0, 0, 0,    0,    0,    0,    0.01 };
    final double[] usa =    { 0, 0, 0.14, 0.28, 0.5,  0.83, 1.39 };
    int startingYear = 1983;
    CellularData datatable;
    int numRows = 3;
    int numColumns = canada.length;
    datatable = new CellularData(numRows, numColumns, startingYear);
    datatable.insert("canada", canada);
    datatable.insert("mexico", mexico);
    datatable.insert("usa", usa);

    // print array content
    for (Object[] row : datatable.array) {
      for (Object cell : row) {
        System.out.print(cell + "\t");
      }
      System.out.println();
    }
  }
}