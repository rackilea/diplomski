public class Quiz implements ActionListener {

    private static Label lblInput;
    private static TextField tfInput;
    private static String cityIn;

    public void europe() {
        ....
        tfInput.addActionListener(new CustomActionListener());
        ...
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Your code
    }
}

class CustomActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // Your code
    }
}