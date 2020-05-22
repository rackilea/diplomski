import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class RowGroupInTableTest {
  private JComponent makeUI() {
    String[] titles = new String[] {"Name", "Last job duration", "Book #"};
    DefaultTableModel model = new DefaultTableModel(null, titles) {
      @Override public Class<?> getColumnClass(int column) {
        return MyData.class;
      }
    };
    addMyData(model, new MyData("Tom",     17, "Book1"));
    addMyData(model, new MyData("Tom",     23, "Book2"));
    addMyData(model, new MyData("Tom",     25, "Book3"));
    addMyData(model, new MyData("Polazzo", 41, "Book1"));
    addMyData(model, new MyData("Polazzo", 45, "Book2"));
    addMyData(model, new MyData("Polazzo", 12, "Book3"));
    addMyData(model, new MyData("Anna",     1, "Book3"));
    addMyData(model, new MyData("Anna",    33, "Book5"));

    JTable table = new JTable(model);
    table.setFillsViewportHeight(true);
    table.setDefaultRenderer(MyData.class, new MyRenderer());

    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
    Comparator<MyData> c = Comparator.comparing(MyData::getName);
    sorter.setComparator(0, c);
    sorter.setComparator(1, c.thenComparing(Comparator.comparingInt(MyData::getDuration)));
    sorter.setComparator(2, c.thenComparing(Comparator.comparing(MyData::getBook)));
    table.setRowSorter(sorter);

    return new JScrollPane(table);
  }
  private static void addMyData(DefaultTableModel model, MyData data) {
    //Omission work...
    model.addRow(Collections.nCopies(3, data).toArray());
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new RowGroupInTableTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class MyData {
  private final String name;
  private final int duration;
  private final String book;
  protected MyData(String name, int duration, String book) {
    this.name = name;
    this.duration = duration;
    this.book = book;
  }
  public String getName() {
    return name;
  }
  public int getDuration() {
    return duration;
  }
  public String getBook() {
    return book;
  }
}

class MyRenderer implements TableCellRenderer {
  TableCellRenderer def = new DefaultTableCellRenderer();
  @Override public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected, boolean hasFocus,
      int row, int column) {
    JLabel orig = (JLabel) def.getTableCellRendererComponent(
        table, value, isSelected, hasFocus, row, column);
    orig.setHorizontalAlignment(SwingConstants.LEFT);
    MyData data = (MyData) value;
    switch (table.convertColumnIndexToModel(column)) {
    case 0:
      String str = data.getName();
      if (row > 0) {
        //if (table.getModel().getValueAt(row-1, column).equals(value)) {
        //Since it compares with the value of the previous line on the display,
        //table.getModel() is not needed
        MyData prev = (MyData) table.getValueAt(row - 1, column);
        if (Objects.equals(prev.getName(), str)) {
          str = " ";
        }
      }
      orig.setText(str);
      break;
    case 1:
      orig.setHorizontalAlignment(SwingConstants.RIGHT);
      orig.setText("" + data.getDuration());
      break;
    case 2:
      orig.setText(data.getBook());
      break;
    default:
      break;
    }
    return orig;
  }
}