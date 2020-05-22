public class LimitInputValue {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();

        final JTextField jTextField = new JTextField();

        jframe.add(jTextField);
        jframe.pack();
        jframe.setVisible(true);

        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String value = jTextField.getText();
                if (value == null || value.isEmpty()) return;
                String newValue = "";
                for (int i = 0; i < value.length(); ++i) {
                    if (Character.isDigit(value.charAt(i))) {
                        newValue += value.charAt(i);

                    }
                }
                jTextField.setText(newValue);
            }
        });
    }
}