import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableToTextArea
{
  private static DefaultTableModel tableModel;
  private static JTextArea textArea = new JTextArea();

  public static void main(String[] args)
  {
    JButton button = new JButton("Add Row");
    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        tableModel.addRow(new String[] {"Abc", "15", "2", "30"});
      }
    });

    JFrame f = new JFrame("Table to Text Area");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new GridLayout(3, 1));
    f.getContentPane().add(new JScrollPane(buildTable()));
    f.getContentPane().add(new JScrollPane(textArea));
    f.getContentPane().add(button);
    f.setBounds(300, 200, 500, 400);
    f.setVisible(true);
  }

  private static JTable buildTable()
  {
    tableModel = new DefaultTableModel(new String[0][0], new String[] {"Item Name", "Price", "Qty", "Total"});
    tableModel.addTableModelListener(new TableModelListener()
    {
      @Override
      public void tableChanged(TableModelEvent e)
      {
        int row = tableModel.getRowCount();

        textArea.setText("_____________________________________________\n"
            + "Item Name\tPrice\tQty.\tTotal\n"
            + "_____________________________________________");
        for (int i = 0; i < row; i++)
        {
          textArea.append("\n"
              + tableModel.getValueAt(i, 0) // Column index is changed
              + "\t" + tableModel.getValueAt(i, 1) // Column index is changed
              + "\t" + tableModel.getValueAt(i, 2) // Column index is changed
              + "\t" + tableModel.getValueAt(i, 3) // Column index is changed
          );
        }
      }
    });
    return new JTable(tableModel);
  }
}