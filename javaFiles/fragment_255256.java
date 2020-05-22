import javax.swing.*;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

public class CopyCell
{
  public static void main(String[] args)
  {
    JTable table = new JTable(
        new String[][] {{"R1C1", "R1C2"}, {"R2C1", "R2C2"}},
        new String[] {"Column 1", "Column 2"});

    table.getActionMap().put("copy", new AbstractAction()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String cellValue = table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn()).toString();
        StringSelection stringSelection = new StringSelection(cellValue);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
      }
    });

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table));
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}