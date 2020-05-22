public class MenuBar {

    private MainFrame mainFrame;

    public MenuBar(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /* other code */


    class newReport implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            mainFrame.RemoveAllfromMainPanel();
        }
    }
 }