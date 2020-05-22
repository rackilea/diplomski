JPanel contentPane = new JPanel();
JFrame fr = new JFrame();
JButton someButton = new JButton("Button");
JTextField textField = new JTextField(10);
textField.setFocusTraversalKeysEnabled(false);
textField.addKeyListener(new KeyAdapter() {

    @Override
    public void keyPressed(final KeyEvent ke) {

        JTextField source = (JTextField) ke.getSource();

        if (ke.getKeyCode() == KeyEvent.VK_TAB) {

            if (source.getText().length() >= 5) {

                System.out.println("Tab with valid text, transferring focus");

                source.transferFocus();// or someButton.requestFocus()

            } else {

                System.out.println("Tab with invalid text");
            }

        }

    }

});


contentPane.add(textField);
contentPane.add(someButton);
fr.setContentPane(contentPane);

fr.pack();
fr.setVisible(true);