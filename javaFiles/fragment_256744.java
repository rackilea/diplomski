class ButtonListener implements ActionListener {
    private JButton lastButtonPressed = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (lastButtonPressed == null) {
            // then this is the first button
            lastButtonPressed = source;
        } else {
            // this is the 2nd button
            if (source == lastButtonPressed) {
                // the dufus is pushing the same button -- do nothing
                return;
            } else {
                // compare source and lastButtonPressed to see if same images (icons?)
                // if not the same, use a Timer to hold both open for a short period of time
                // then close both
                lastButtonPressed = null;
            }
        }
    }
}