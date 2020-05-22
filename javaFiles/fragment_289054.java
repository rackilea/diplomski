public static void main(String[] args) {
    JFrame frame = new JFrame();
    ....
    NumberText numberText = new NumberText();
    Button1 button = new Button1(numberText);
    JPanel pan = new JPanel();
    pan.add(numberText);
    pan.add(button);
    frame.add(pan);
    .....
}


public class Button1 extends JPanel {
    private JButton push;
    private JLabel label;
    NumberText alreadyDisplayed;
    public Button1 (NumberText alreadyDisplayed) {
        this.alreadyDisplayed = alreadyDisplayed;
        push = new JButton ("1");
        push.addActionListener (new ButtonListener());
        add(push);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            alreadyDisplayed.Edit("1");
        }
    }
}