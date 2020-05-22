public static void main(String[] args) {
        JFrame f = new JFrame("Demo");
        f.setLayout(new FlowLayout());
        f.setSize(300, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        JLabel label = new JLabel("enter your number: ");
        JTextField userText = new JTextField(6);
        JButton button = new JButton("OK");
        JLabel label1 = new JLabel();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int i = Integer.parseInt(userText.getText());
                    label1.setText(Integer.toString(i));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(f,
                            "Input integer number ",
                            "NumberFormatException",
                            JOptionPane.ERROR_MESSAGE);
                    userText.setText("");
                }
            }
        });

        f.add(label);
        f.add(userText);
        f.add(button);
        f.add(label1);
        f.setVisible(true);
    }