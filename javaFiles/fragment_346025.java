import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class CheckBoxPanelCellTest {
  private JComponent makeUI() {
    String[] columnNames = {"String", "Boolean"};
    Object[][] data = {
      {"AAA", true}, {"bbb", false}
    };
    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
      @Override public Class<?> getColumnClass(int column) {
        if (column == 1) {
          return Boolean.class;
        }
        return super.getColumnClass(column);
      }
      @Override public boolean isCellEditable(int row, int column) {
        return column == 1;
      }
    };
    JTable table = new JTable(model) {
      @Override public void updateUI() {
        setDefaultEditor(Boolean.class, null);
        super.updateUI();
        setDefaultEditor(Boolean.class, new CheckBoxPanelEditor());
      }
    };
    table.setRowHeight(24);
    table.setRowSelectionAllowed(true);
    table.setShowVerticalLines(false);
    table.setIntercellSpacing(new Dimension(0, 1));
    table.setFocusable(false);
    return new JScrollPane(table);
  }
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new CheckBoxPanelCellTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class CheckBoxPanelEditor extends AbstractCellEditor implements TableCellEditor {
  private final JPanel p = new JPanel(new GridBagLayout());
  private final JCheckBox checkBox = new JCheckBox();
  public CheckBoxPanelEditor() {
    super();
    checkBox.setOpaque(false);
    checkBox.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
    p.add(checkBox);
    p.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
  }
  @Override public Component getTableCellEditorComponent(
      JTable table, Object value, boolean isSelected, int row, int column) {
    checkBox.setSelected(Objects.equals(value, Boolean.TRUE));
    p.setBackground(table.getSelectionBackground());
    return p;
  }
  @Override public Object getCellEditorValue() {
    return checkBox.isSelected();
  }
}