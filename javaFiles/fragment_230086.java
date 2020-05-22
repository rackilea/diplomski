public class Test extends JFrame {

    String userWord = "";
    JTextField userInput = new JTextField(10);
    JButton submit = new JButton("Submit");

    public Test() {
        super("Camo Cipher");
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // This center the window on the screen
        submit.addActionListener( (e)-> {
            submitAction();
        });
        centerPanel.add(userInput);
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        southPanel.add(submit);
        Box theBox = Box.createVerticalBox();
        theBox.add(Box.createVerticalStrut(100));
        theBox.add(centerPanel);
        theBox.add(Box.createVerticalStrut(200));
        theBox.add(southPanel);
        add(theBox);
    }

    private void submitAction() {
        // You can do some validation here before assign the text to the variable 
        userWord = userInput.getText();
    }

    public static void main(String[] args) {
        new Test().setVisible(true);
    }
}