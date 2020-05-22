import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ParseTableData {

  public static int findFirstRowWithNoEmptyCells(String[] resultLines) {
    String[] columnNames = resultLines[0].split("\\s+");
    for (int i = 2; i < resultLines.length; i++) {
      String[] row = resultLines[i].trim().split("\\s+");

      if (columnNames.length == row.length) {
        return i;
      }
    }
    throw new IllegalStateException("Not a single complete row.");
  }

  public static int[] calculateColumnWidths(String rowWithNoEmptyCells) {
    int columnCount = rowWithNoEmptyCells.trim().split("\\s+").length;
    int[] columnWidths = new int[columnCount];

    int currentColumnIndex = 0;
    int currentWidth = 0;
    boolean nonSpaceCharFound = false;
    for (int i = 0; i < rowWithNoEmptyCells.length(); i++) {
      char c = rowWithNoEmptyCells.charAt(i);
      if (c == ' ') {
        if (!nonSpaceCharFound) {
          currentWidth++;
        }
        else {
          columnWidths[currentColumnIndex] = i;
          currentWidth = 1;
          nonSpaceCharFound = false;
          currentColumnIndex++;
        }
      }
      else {
        nonSpaceCharFound = true;
        currentWidth++;
      }
    }
    return columnWidths;
  }

  public static String[] parseRow(String line, int[] columnWidths) {
    String[] row = new String[columnWidths.length];
    for (int i = 0; i < row.length; i++) {
      if (i == 0) {
        row[i] = line.substring(0, columnWidths[i]).trim();
      }
      else if (i == row.length - 1) {
        row[i] = line.substring(columnWidths[i-1]).trim();
      }
      else {
        row[i] = line.substring(columnWidths[i-1], columnWidths[i]).trim();
      }
    }

    return row;
  }

  public static void main(String[] args)
  {
    String[] resultLines = new String[] {
        "Handles   NPM(K)    PM(K)      WS(K)     CPU(s)   Id  SI  ProcessName                                                  ",
        "-------   ------    -----      -----     ------   --  -- -----------                                                  ",
        "    322      17     3308      13800              2572   0  armsvc                                                       ",
        "    171      10     6304      11224       0.11   3836   0  audiodg                                                      ",
        "    591      31    11864      42480       1.39   3660   9  backgroundTaskHost                                           ",
        "   1488      55    28736      61776              1892   0  CcmExec                                                      ",
        "     42       4     2332       3816       0.05  10720   9  cmd                                                          "
    };

    int indexOfFirstRowWithNoEmptyCells = findFirstRowWithNoEmptyCells(resultLines);
    int[] columnWidths = calculateColumnWidths(resultLines[indexOfFirstRowWithNoEmptyCells]);

    String[] columns = resultLines[0].split("\\s+");

    String[][] data = new String[resultLines.length - 2][];
    for (int i = 2; i < resultLines.length; i++) {
      data[i-2] = parseRow(resultLines[i], columnWidths);
    }

    DefaultTableModel tableModel = new DefaultTableModel(data, columns);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new JScrollPane(new JTable(tableModel)));
    frame.pack();
    frame.setVisible(true);
  }
}