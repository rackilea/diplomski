public class Exercise1 extends JFrame implements ActionListener{

    private static final String BUTTON_ACTION = "List all Locales";

    public Exercise1(){
        // ...
        button.setText(BUTTON_ACTION);
        // ...
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getActionCommand().equals(BUTTON_ACTION)){
            // ...