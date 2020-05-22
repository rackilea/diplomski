private static JTextPane createTextPane() {
    JTextPane result = new JTextPane();

    result.setContentType("text/html");
    result.setEditable(false);
    result.setText("<html>Hello World Hello World Hello World Hello World Hello World Hello World</html>");

    return result;
}