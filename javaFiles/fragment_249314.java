public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    if (source instanceof JButton && ((JButton) source).getText().equals("Add Book")) {
        ...
    }
}