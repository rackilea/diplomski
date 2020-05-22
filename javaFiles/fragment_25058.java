import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MultipleComponentCellTest {
  private final String[] columnNames = {"Band Type"};
  private final Object[][] data = {
    {new BandType("manual",  50)},
    {new BandType("locked", 100)},
    {new BandType("manual",  32)},
    {new BandType("locked",   0)},
  };
  private final TableModel model = new DefaultTableModel(data, columnNames) {
    @Override public Class<?> getColumnClass(int column) {
      return BandType.class;
    }
  };
  private final JTable table = new JTable(model);
  public JComponent makeUI() {
    table.setRowHeight(42);
    table.setDefaultRenderer(BandType.class, new BandTypeRenderer());
    table.setDefaultEditor(BandType.class, new BandTypeEditor());
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
    try {
      for (UIManager.LookAndFeelInfo laf: UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(laf.getName())) {
          UIManager.setLookAndFeel(laf.getClassName());
        }
      }
    } catch (ClassNotFoundException | InstantiationException
           | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new MultipleComponentCellTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class BandType {
  public final String state;
  public final int value;
  public BandType(String state, int value) {
    this.state = state;
    this.value = value;
  }
}

class BandTypePanel extends JPanel {
  private static String DEFAULT = "0";
  public final JSlider slider = new JSlider(0, 100);
  public final JTextField textField = new JTextField(3);
  public final JComboBox<String> comboBox = new JComboBox<>(
      new String[] {"manual", "locked"});
  public BandTypePanel() {
    super(new BorderLayout(5, 5));
    setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    comboBox.addItemListener(new ItemListener() {
      @Override public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
          boolean f = "manual".equals(e.getItem());
          slider.setEnabled(f);
          textField.setEnabled(f);
        }
      }
    });

    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);

    slider.setOpaque(false);
    slider.setFocusable(false);
    slider.getModel().addChangeListener(new ChangeListener() {
      @Override public void stateChanged(ChangeEvent e) {
        BoundedRangeModel m = (BoundedRangeModel) e.getSource();
        textField.setText(Objects.toString(m.getValue(), DEFAULT));
      }
    });

    JPanel p = new JPanel();
    p.setOpaque(false);
    p.add(comboBox);
    p.add(textField);
    p.add(new JLabel("%"));

    add(p, BorderLayout.WEST);
    add(slider);
  }
  public void updateValue(BandType bt) {
    comboBox.setSelectedItem(bt.state);
    slider.setValue(bt.value);
    textField.setText(Objects.toString(bt.value, DEFAULT));
  }
}

class BandTypeRenderer extends BandTypePanel implements TableCellRenderer {
  public BandTypeRenderer() {
    super();
    setName("Table.cellRenderer");
  }
  @Override public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
    setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
    if (value instanceof BandType) {
      updateValue((BandType) value);
    }
    return this;
  }
}

class BandTypeEditor extends BandTypePanel implements TableCellEditor {
  protected transient ChangeEvent changeEvent;
  @Override public Component getTableCellEditorComponent(
    JTable table, Object value, boolean isSelected, int row, int column) {
    this.setBackground(table.getSelectionBackground());
    if (value instanceof BandType) {
      updateValue((BandType) value);
    }
    return this;
  }
  @Override public Object getCellEditorValue() {
    return new BandType(comboBox.getSelectedItem().toString(), slider.getValue());
  }
  //Copied from AbstractCellEditor
  //protected EventListenerList listenerList = new EventListenerList();
  @Override public boolean isCellEditable(EventObject e) {
    return true;
  }
  @Override public boolean shouldSelectCell(EventObject anEvent) {
    return true;
  }
  @Override public boolean stopCellEditing() {
    fireEditingStopped();
    return true;
  }
  @Override public void cancelCellEditing() {
    fireEditingCanceled();
  }
  @Override public void addCellEditorListener(CellEditorListener l) {
    listenerList.add(CellEditorListener.class, l);
  }
  @Override public void removeCellEditorListener(CellEditorListener l) {
    listenerList.remove(CellEditorListener.class, l);
  }
  public CellEditorListener[] getCellEditorListeners() {
    return listenerList.getListeners(CellEditorListener.class);
  }
  protected void fireEditingStopped() {
    // Guaranteed to return a non-null array
    Object[] listeners = listenerList.getListenerList();
    // Process the listeners last to first, notifying
    // those that are interested in this event
    for (int i = listeners.length - 2; i >= 0; i -= 2) {
      if (listeners[i] == CellEditorListener.class) {
        // Lazily create the event:
        if (Objects.isNull(changeEvent)) {
          changeEvent = new ChangeEvent(this);
        }
        ((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
      }
    }
  }
  protected void fireEditingCanceled() {
    // Guaranteed to return a non-null array
    Object[] listeners = listenerList.getListenerList();
    // Process the listeners last to first, notifying
    // those that are interested in this event
    for (int i = listeners.length - 2; i >= 0; i -= 2) {
      if (listeners[i] == CellEditorListener.class) {
        // Lazily create the event:
        if (Objects.isNull(changeEvent)) {
          changeEvent = new ChangeEvent(this);
        }
        ((CellEditorListener) listeners[i + 1]).editingCanceled(changeEvent);
      }
    }
  }
}