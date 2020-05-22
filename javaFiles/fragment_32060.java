public class GuiHandler extends javax.swing.JFrame {

  //lots of your other code
  public void launchFileChooser() {
     SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch(Exception e) {
                e.printStackTrace();
            }
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
        }
    });
  }

  public static void main(String[] args) {
     GuiHandler handler = new GuiHandler();
     handler.launchFileChooser();
  }
}