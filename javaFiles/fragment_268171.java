private class MenuListener implements ActionListener {
    @Override public void actionPerformed(ActionEvent e) {
        Object caller = e.getSource();
        if (caller != null && caller.instanceOf JMenuItem) {
            JMenuItem src = (JMenuItem)caller;
            String size = src.getText();

            if (size != null) {
                float fontSize = Float.parseFloat(size);
                texto.setFont(aryal.deriveFont(fontSize));
            }
        }
    }
}