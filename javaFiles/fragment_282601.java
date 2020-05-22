import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Testing
{
  public void buildGUI()
  {
    JTabbedPane tp = new JTabbedPane();
    tp.addTab("A",getPanel("A"));
    tp.addTab("B",getPanel("B"));
    tp.addTab("C",getPanel("C"));
    //Control Header space area..
    final boolean showTabsHeader = false;
    tp.setUI(new javax.swing.plaf.metal.MetalTabbedPaneUI(){
        @Override
        protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
            if (showTabsHeader) {
                return super.calculateTabAreaHeight(tabPlacement, horizRunCount, maxTabHeight);
            } else {
                return 0;
            }
        }
      protected void paintTabArea(Graphics g,int tabPlacement,int selectedIndex){}
    });

    JFrame f = new JFrame();
    f.getContentPane().add(tp);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
  public JPanel getPanel(String tabText)
  {
    JPanel p = new JPanel();
    p.add(new JLabel(tabText));
    return p;
  }
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Testing().buildGUI();
      }
    });
  }
}