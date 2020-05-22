JTextPane tp = new JTextPane();
tp.insertIcon(new ImageIcon("mySuperAwesomePictureSomewhere.jpg"));
try {
    Document doc = tp.getDocument();
    doc.insertString(doc.getLength(), "\nTruer words were never spoken", null);
} catch (BadLocationException ex) {
    ex.printStackTrace();
}
add(new JScrollPane(tp));