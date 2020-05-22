ActionListener actionListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            JButton pressedButton = (JButton) e.getSource();
            String buttonsName = pressedButton.getName();
            String buttonsText = pressedButton.getText();
            // do something with those
        }
    }
};

JButton a = new JButton("A");
a.addActionListener(actionListener);
JButton b = new JButton("B");
b.addActionListener(actionListener);
....