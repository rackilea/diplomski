@Override
public void update() {
    textArea.getDocument().removeDocumentListener(reference);
    textArea.setText(reference.getState()); // Call to update each text box
    textArea.getDocument().addDocumentListener(reference);
}