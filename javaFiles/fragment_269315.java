InputMap im = searchTF.getInputMap(JTextField.WHEN_IN_FOCUSED_WINDOW);
    ActionMap am = searchTF.getActionMap();
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ENTER");
    am.put("ENTER", new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
             String text = searchTF.getText();
             if (text.isEmpty()) {
                 sorter.setRowFilter(null);
             } else {
                 try {
                     sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 4));
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
        }
    });