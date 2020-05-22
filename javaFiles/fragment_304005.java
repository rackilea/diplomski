public static void main(String[] args) {
    JTextArea ta = new JTextArea();
    JScrollPane sp = new JScrollPane(ta);

    // disables editing
    ta.setEditable(false);

    // enable line wrap to wrap text around
    ta.setLineWrap(true);

    // words will not be cut off when wrapped around
    ta.setWrapStyleWord(true);

    // displays the text you read in
    ta.append( *text you read in* );
}