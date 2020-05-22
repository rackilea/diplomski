private class CheckBoxListener implements ItemListener {

    private ActionListener buttonActionListener = new thehandler();

    @Override
    public void itemStateChanged(ItemEvent event) {
        if(one.isSelected() ^ two.isSelected()) {
            button.addActionListener(buttonActionListener);
        } else {
            button.removeActionListener(buttonActionListener);
        }
    }
}