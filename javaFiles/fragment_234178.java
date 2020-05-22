popupMenu.add(new JMenuItem(new AbstractAction("Copy") {
    @Override
    public void actionPerformed(final ActionEvent e) {

        String text = field.getText(); // replace this to get the text you want to be copied
        StringSelection stsel = new StringSelection(text);
        Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
        system.setContents(stsel, stsel);

    }
}));