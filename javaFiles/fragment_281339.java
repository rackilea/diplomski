import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.Position;

public class MyTable2 extends JPanel {
  public JScrollPane jScrollPane1;
  public JTextField searchField;
  public JTable table;
  private final Object[] data = new Object[6];
  private final ArrayList<Object[]> rows = new ArrayList<>();

  private MyTable2() {
    table = new JTable();
    table.setAutoCreateRowSorter(true);
    table.setModel(new DefaultTableModel(
                     new String[] {
                       "Description", "Code", "Qty", "Cost", "Rate", "Packing"
                     }, 0
    ) {
      Class[] types = new Class[] {
        String.class, String.class, Integer.class, Double.class, Double.class, String.class
      };
      @Override public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
      }
      @Override public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
      }
    });

    table.setColumnSelectionAllowed(true);
    table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    table.getTableHeader().setReorderingAllowed(false);

    table.getColumnModel().getSelectionModel().setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    table.setPreferredScrollableViewportSize(new Dimension(800, 600));
    table.setFillsViewportHeight(true);
    table.setRowHeight(30);

    //table.addKeyListener(new SearchingKeyAdapter(table));
    table.addKeyListener(new TableNextMatchKeyHandler());

    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane);
    addRowData();
    table.changeSelection(0, 0, false, false);
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("MyTable");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new MyTable2());
    frame.pack();
    frame.setVisible(true);
  }

  private void addRowData() {
    String desc = "SL 123";
    Integer code = 12345;
    Integer qty = 10;
    Double rate = new Double(1000);
    Double cost = new Double(900);
    String pack = "10x10x10";
    data[0] = desc;
    data[1] = code;
    data[2] = qty;
    data[3] = cost;
    data[4] = rate;
    data[5] = pack;
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    for (int i = 0; i < 5; i++) {
      data[0] = "SL " + i;
      rows.add(data);
      model.addRow(data);
    }
    rows.clear();
    for (int i = 0; i < 5; i++) {
      data[0] = "SC " + i;
      rows.add(data);
      model.addRow(data);
    }
    data[0] = "AP";
    model.addRow(data);
    data[0] = "GP";
    model.addRow(data);
    data[0] = "PS";
    model.addRow(data);
    data[0] = "PP";
    model.addRow(data);
    data[0] = "BHM";
    model.addRow(data);
    data[0] = "BGP";
    model.addRow(data);
  }

  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}

//@see javax/swing/plaf/basic/BasicListUI.Handler
//@see javax/swing/plaf/basic/BasicTreeUI.Handler
class TableNextMatchKeyHandler extends KeyAdapter {
  private static final int TARGET_COLUMN = 0;
  private static final long TIME_FACTOR = 500L;
  private String prefix = "";
  private String typedString;
  private long lastTime;
  private boolean isNavigationKey(KeyEvent event) {
    JTable table = (JTable) event.getComponent();
    InputMap im = table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    KeyStroke key = KeyStroke.getKeyStrokeForEvent(event);
    return Objects.nonNull(im) && Objects.nonNull(im.get(key));
  }
  @Override public void keyPressed(KeyEvent e) {
    if (isNavigationKey(e)) {
      prefix = "";
      typedString = "";
      lastTime = 0L;
    }
  }
  @Override public void keyTyped(KeyEvent e) {
    JTable src = (JTable) e.getComponent();
    int max = src.getRowCount();
    if (max == 0 || e.isAltDown() || isNavigationKey(e)) {
        //|| BasicGraphicsUtils.isMenuShortcutKeyDown(e)) {
      // Nothing to select
      return;
    }
    boolean startingFromSelection = true;
    char c = e.getKeyChar();
    int increment = e.isShiftDown() ? -1 : 1;
    long time = e.getWhen();
    int startIndex = src.getSelectedRow();
    if (time - lastTime < TIME_FACTOR) {
      typedString += c;
      if (prefix.length() == 1 && c == prefix.charAt(0)) {
        // Subsequent same key presses move the keyboard focus to the next
        // object that starts with the same letter.
        startIndex += increment;
      } else {
        prefix = typedString;
      }
    } else {
      startIndex += increment;
      typedString = String.valueOf(c);
      prefix = typedString;
    }
    lastTime = time;

    selectAndScrollNextMatch(src, max, e, prefix, startIndex, startingFromSelection);
  }
  private static void selectAndScrollNextMatch(
      JTable src, int max, KeyEvent e, String prefix,
      int startIndex, boolean startingFromSelection) {
    int start = startIndex;
    boolean isStartingSelection = startingFromSelection;
    if (start < 0 || start >= max) {
      if (e.isShiftDown()) {
        start = max - 1;
      } else {
        isStartingSelection = false;
        start = 0;
      }
    }
    Position.Bias bias = e.isShiftDown() ? Position.Bias.Backward : Position.Bias.Forward;
    int index = getNextMatch(src, prefix, start, bias);
    if (index >= 0) {
      src.getSelectionModel().setSelectionInterval(index, index);
      src.scrollRectToVisible(src.getCellRect(index, TARGET_COLUMN, true));
    } else if (isStartingSelection) { // wrap
      index = getNextMatch(src, prefix, 0, bias);
      if (index >= 0) {
        src.getSelectionModel().setSelectionInterval(index, index);
        src.scrollRectToVisible(src.getCellRect(index, TARGET_COLUMN, true));
      }
    }
  }
  //@see javax/swing/JList#getNextMatch(String prefix, int startIndex, Position.Bias bias)
  //@see javax/swing/JTree#getNextMatch(String prefix, int startIndex, Position.Bias bias)
  public static int getNextMatch(
      JTable table, String prefix, int startingRow, Position.Bias bias) {
    int max = table.getRowCount();
    if (Objects.isNull(prefix) || startingRow < 0 || startingRow >= max) {
      throw new IllegalArgumentException();
    }
    String uprefix = prefix.toUpperCase(Locale.ENGLISH);

    // start search from the next/previous element froom the
    // selected element
    int increment = bias == Position.Bias.Forward ? 1 : -1;
    int row = startingRow;
    do {
      Object value = table.getValueAt(row, TARGET_COLUMN);
      String text = Objects.toString(value, "");
      if (text.toUpperCase(Locale.ENGLISH).startsWith(uprefix)) {
        return row;
      }
      row = (row + increment + max) % max;
    } while (row != startingRow);
    return -1;
  }
}