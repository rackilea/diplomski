import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
public class NonEditableButKeepRowSelectionTableTest {
  public JComponent makeUI() {
    String[] columnNames = {"String", "Integer", "Boolean"};
    Object[][] data = {
      {"aaa", 12, true}, {"bbb", 5, false},
      {"CCC", 92, true}, {"DDD", 0, false}
    };
    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
      @Override public Class<?> getColumnClass(int column) {
        return getValueAt(0, column).getClass();
      }
    };
    JTable table = new JTable(model);
    //table.setEnabled(false);

    table.putClientProperty("JTable.autoStartsEdit", Boolean.FALSE);

    table.getActionMap().put("none", new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        System.out.println("dummy");
      }
    });
    table.getInputMap().put(KeyStroke.getKeyStroke("pressed F2"), "none");

    for (Class c: Arrays.asList(Object.class, Number.class, Boolean.class)) {
      //TEST: table.setDefaultEditor(c, null);
      TableCellEditor ce = table.getDefaultEditor(c);
      if (ce instanceof DefaultCellEditor) {
        ((DefaultCellEditor) ce).setClickCountToStart(Integer.MAX_VALUE);
      }
    }
    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(table));
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new NonEditableButKeepRowSelectionTableTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}