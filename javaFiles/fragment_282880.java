public class MyListener implements ActionListener{

    private MyPanel myPanel;

    public MyListener(MyPanel myPanel) {
        this.myPanel = myPanel;
    }

    public void ActionPerformed(ActionEvent e) {
        myPanel.getTLabel().setText(myPanel.getTString());
    }
}