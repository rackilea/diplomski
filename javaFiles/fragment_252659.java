public void addJTextArea(JScrollPane scrollPane){
    scrollPane.setViewportView(textArea);
    textArea.setLineWrap(true);
    textArea.setEditable(true);
    textArea.setVisible(true);
}