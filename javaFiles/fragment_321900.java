JPanel boggleGrid = new JPanel(new GridLayout(4, 4));

ActionListener disableButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent event)
    {
        // event.getSource() will return a reference to the control that
        // fired the event. In this case, a JButton. We protect
        // ourselves from a ClassCastException just in case though.
        if (!(event.getSource() instanceof JButton)) {
            return;
        }

        ((JButton) event.getSource()).setEnabled(false);
    }
};

theModel.randomLetters();

for (int i = 0; i < 16; i++) {
    JButton button = new JButton(theModel.letters.get(i));
    button.addActionListener(disableButtonListener);
    boggleGrid.add(button);
}

frame.add(boggleGrid, BorderLayout.CENTER);