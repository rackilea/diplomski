numTable.addDocumentListener(new MyDocumentListener());
…
class MyDocumentListener implements DocumentListener {

    public void insertUpdate() {
        update();
    }
    public void removeUpdate() {
        update();
    }
    public void changedUpdate(DocumentEvent e) {}

    public void update() {
        tableLabel.setText(numTable.getText());
    }
}