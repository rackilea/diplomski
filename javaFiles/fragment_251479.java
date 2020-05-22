protected JScrollPane makeAEditorPane() {
    JScrollPane editorScrollPane = new JScrollPane(makeAEditorList());
    editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    editorScrollPane.setPreferredSize(new Dimension(250, 145));
    editorScrollPane.setMinimumSize(new Dimension(10, 10));

    return editorScrollPane;
}

protected JEditorPane makeAEditorList() {
    editorPane = new JEditorPane();
    editorPane.setEditable(false);

    return editorPane;
}

private void feedEditor(String name) {
    URL helpURL = Bobbleheads.class.getResource("/images/bobbleheads/" + name + ".html");

    if (helpURL != null) {
        try {
            editorPane.setPage(helpURL);
        } catch (IOException e) {
            System.err.println("Attempted to read a bad URL: " + helpURL);
        }
    } else {
        System.err.println("Couldn't find file: TextSampleDemoHelp.html");
    }
}

public void valueChanged(ListSelectionEvent e) {
    JList<?> list = (JList<?>) e.getSource();
    updateLabel(imageNames[list.getSelectedIndex()]);
    feedEditor(htmlDocs[list.getSelectedIndex()]);

}