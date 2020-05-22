import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ViewFiles2 extends JFrame {
  private JScrollPane jScrollPane1;
  private JButton viewFilesCloseButton;
  private JTextArea viewFilesTextArea;
  public ViewFiles2() {
    initComponents();
    displayFiles();
  }
  private void initComponents() {
      //NG?: UIManager.getLookAndFeelDefaults().put("ScrollBar.minimumThumbSize", new Dimension(30, 30));
      //OK?: UIManager.getDefaults().put("ScrollBar.minimumThumbSize", new Dimension(30, 30));

    jScrollPane1 = new JScrollPane();

    UIDefaults def = new UIDefaults();
    def.put("ScrollBar.minimumThumbSize", new Dimension(30, 30));
    jScrollPane1.getVerticalScrollBar().putClientProperty("Nimbus.Overrides", def);

    viewFilesTextArea = new JTextArea(20, 5);
    viewFilesCloseButton = new JButton("Close");
    jScrollPane1.setViewportView(viewFilesTextArea);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
      .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewFilesCloseButton)
                .addGap(29, 29, 29))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(viewFilesCloseButton)
                .addContainerGap())
    );

    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    pack();
  }
  public void displayFiles() {
    viewFilesTextArea.setText(String.join("\n", Collections.nCopies(500, "aaaaaaaaaaaaa")));
  }
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    //OK?: UIManager.getLookAndFeelDefaults().put("ScrollBar.minimumThumbSize", new Dimension(30, 30));
    //NG?: UIManager.getDefaults().put("ScrollBar.minimumThumbSize", new Dimension(30, 30));

    EventQueue.invokeLater(() -> {
      new ViewFiles2().setVisible(true);
    });
  }
}