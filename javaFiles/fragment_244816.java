import javax.swing.*;
import java.awt.*;

public class TableHeaderFont
{
  public static void main(String[] args)
  {
    JTable table = new JTable(new String[][] {{"11", "22"}, {"33", "44"}}, new String[] {"ABC", "DEF"});
    table.getTableHeader().setBackground(new Color(239,198,46));
    table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 12));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new JScrollPane(table));
    frame.pack();
    frame.setVisible(true);
  }
}