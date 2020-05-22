import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class JTableResizeColumnsDemo implements Runnable
{
  JTable table1, table2;
  TableColumnModelListener columnListener1, columnListener2;
  Map<JTable, TableColumnModelListener> map;

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new JTableResizeColumnsDemo());
  }

  public void run()
  {
    Vector<String> names = new Vector<String>();
    names.add("One");
    names.add("Two");
    names.add("Three");

    table1 = new JTable(null, names);
    table2 = new JTable(null, names);

    columnListener1 = new ColumnChangeListener(table1, table2);
    columnListener2 = new ColumnChangeListener(table2, table1);

    table1.getColumnModel().addColumnModelListener(columnListener1);
    table2.getColumnModel().addColumnModelListener(columnListener2);

    map = new HashMap<JTable, TableColumnModelListener>();
    map.put(table1, columnListener1);
    map.put(table2, columnListener2);

    JPanel p = new JPanel(new GridLayout(2,1));
    p.add(new JScrollPane(table1));
    p.add(new JScrollPane(table2));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(p);
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  class ColumnChangeListener implements TableColumnModelListener
  {
    JTable sourceTable;
    JTable targetTable;

    public ColumnChangeListener(JTable source, JTable target)
    {
      this.sourceTable = source;
      this.targetTable = target;
    }

    public void columnAdded(TableColumnModelEvent e) {}
    public void columnSelectionChanged(ListSelectionEvent e) {}
    public void columnRemoved(TableColumnModelEvent e) {}
    public void columnMoved(TableColumnModelEvent e) {}

    public void columnMarginChanged(ChangeEvent e)
    {
      TableColumnModel sourceModel = sourceTable.getColumnModel();
      TableColumnModel targetModel = targetTable.getColumnModel();
      TableColumnModelListener listener = map.get(targetTable);

      targetModel.removeColumnModelListener(listener);

      for (int i = 0; i < sourceModel.getColumnCount(); i++)
      {
        targetModel.getColumn(i).setPreferredWidth(sourceModel.getColumn(i).getWidth());
      }

      targetModel.addColumnModelListener(listener);
    }
  }
}