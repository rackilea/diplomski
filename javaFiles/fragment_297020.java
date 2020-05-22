private class SelectionListener implements ItemListener {

    JCheckBox checkBox;

    SelectionListener(JCheckBox checkBox) {

        this.checkBox = checkBox;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        (boxPanelMap.get(checkBox)).setVisible(e.getStateChange() == ItemEvent.SELECTED);
        pack();
    }
}