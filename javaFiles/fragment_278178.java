package swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JListDisabledListDemo implements Runnable
{
  private static final String ITEMS[] =
    { "Black", "Blue", "Green", "Orange", "Purple", "Red", "White"};

  private JList jList;
  private JCheckBox chkEnable;

  public static void main(String args[])
  {
    SwingUtilities.invokeLater(new JListDisabledListDemo()); 
  }

  public void run()
  {
    jList = new JList(ITEMS);
    jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scroll = new JScrollPane(jList);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    chkEnable = new JCheckBox("Enable", true);
    chkEnable.addItemListener(new ItemListener()
    {
      public void itemStateChanged(ItemEvent e)
      {
        jList.setEnabled(chkEnable.isSelected());
      }
    });

    JFrame f = new JFrame("Colors");
    Container contentPane = f.getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(scroll, BorderLayout.CENTER);
    contentPane.add(chkEnable, BorderLayout.NORTH);

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(180, 220);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}