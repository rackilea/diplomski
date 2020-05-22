import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableHeaderTooltipWidthTest {
  public JComponent makeUI() {
    TableModel model = new DefaultTableModel(
        new Object[][] {{ "label1", "label2", "label3", "label4"} }, 
        new String[] { "foo", "bar", "foo bar", "bar foo" });
    // How to Use Tables (The Java™ Tutorials)
    // Specifying Tool Tips for Column Headers
    // https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#headertooltip
    JTable table = new JTable(model) {
      //Implement table header tool tips.
      @Override protected JTableHeader createDefaultTableHeader() {
        return new JTableHeader(columnModel) {
          @Override public String getToolTipText(MouseEvent e) {
            int col = columnAtPoint(e.getPoint());
            return String.valueOf(getColumnModel().getColumn(col).getPreferredWidth());
            //int index = columnModel.getColumnIndexAtX(e.getPoint().x);
            //int realIndex = columnModel.getColumn(index).getModelIndex();
            //return String.valueOf(columnModel.getColumn(realIndex).getPreferredWidth());
          }
        };
      }
    };
    return new JScrollPane(table);
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TableHeaderTooltipWidthTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}