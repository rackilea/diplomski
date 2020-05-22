class ButtonPanel extends JPanel {

    public ButtonPanel() {
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");

        add(yellowButton);
        add(blueButton);
        add(redButton);

        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction redAction = new ColorAction(Color.RED);
        ColorAction blueAction = new ColorAction(Color.BLUE);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }

    private class ColorAction implements ActionListener {

        public ColorAction(Color c) {
            backgroundColor = c;
        }

         @Override
         public void actionPerformed(ActionEvent event) {
            setBackground(backgroundColor);
        }
        private Color backgroundColor;
    }
}