import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ParseTableData {

  public static String[] parseRow(String line) {
    String[] row = new String[8];
    row[0] = line.substring(0, 7).trim();
    row[1] = line.substring(7, 15).trim();
    row[2] = line.substring(15, 24).trim();
    row[3] = line.substring(24, 35).trim();
    row[4] = line.substring(35, 46).trim();
    row[5] = line.substring(46, 53).trim();
    row[6] = line.substring(53, 57).trim();
    row[7] = line.substring(57).trim();
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

    String[] columns = resultLines[0].split("\\s+");

    String[][] data = new String[resultLines.length - 2][];
    for (int i = 2; i < resultLines.length; i++) {
      data[i-2] = parseRow(resultLines[i]);
    }

    DefaultTableModel tableModel = new DefaultTableModel(data, columns);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new JScrollPane(new JTable(tableModel)));
    frame.pack();
    frame.setVisible(true);
  }
}