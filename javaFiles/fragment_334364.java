import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class TabSample extends JFrame{
  public void createAndShowGUI() {
    JPanel panel = new JPanel();
    JTextArea ta = new JTextArea(100,50);
    JScrollPane jsp = new JScrollPane(ta);
    JTabbedPane tabbedPane = new JTabbedPane();
    panel.setLayout(new BorderLayout());
    tabbedPane.addTab("Tab one", panel);
    JSplitPane vPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tabbedPane, jsp);
    getContentPane().add(vPane);
    setSize(400,500);
    vPane.setDividerLocation(getHeight()/2);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String args[]) 
  {
      javax.swing.SwingUtilities.invokeLater(new Runnable()
      {
          @Override
          public void run()
          {
              TabSample ts = new TabSample();
              ts.createAndShowGUI();
          }
      });
  }
}