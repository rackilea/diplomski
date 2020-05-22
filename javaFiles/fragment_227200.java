private void resetLastNamePopup() {

    lnPopup.setVisible(false);
    lnPopup.removeAll();

    final String fn = fnTextField.getText();
    final String ln = lnTextField.getText();

    Thread t = new Thread() {

        @Override
        public void run() {
            if(DBHSDatabaseIntermediary.isConnected()
                    && !fn.isEmpty() && !ln.isEmpty()) {

                final String[] names =
                    DBHSDatabaseIntermediary.getLastNames(fn, ln);

                // Rebuild JPopupMenu in AWT event thread.
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        for (String name : names) {
                            if (!name.equals(ln)) {
                                JMenuItem item = new JMenuItem(name);
                                item.addActionListener(lnActionListener);
                                lnPopup.add(item);
                            }
                        }

                        if (names.length > 0 && !names[0].isEmpty()) {
                            lnPopup.setVisible(true);
                            lnPopup.grabFocus();
                        }
                    }
                });
            }
        }// ends run()

    };
    t.start();
}