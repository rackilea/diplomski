private class ButtonActionListener implements ActionListener {

    /*
     * You will probably define a constructor that accepts the two checkboxes
     * as arguments.
     */

    @Override
    public void actionPerformed(ActionEvent event) {
        if (one.isSelected() ^ two.isSelected()) {
            dispose();
        }
    }
}