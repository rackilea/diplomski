@Override
public void insertUpdate(DocumentEvent arg0) {
    doc = (Document) arg0.getDocument();

    try {
        this.textArea.setText(doc.getText(0, doc.getLength()-1));
    } catch (BadLocationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    notifyAllObservers();
}

@Override
public void removeUpdate(DocumentEvent arg0) {
    doc = (Document) arg0.getDocument();

    try {
        this.textArea.setText(doc.getText(0, doc.getLength()-1));
    } catch (BadLocationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    notifyAllObservers();
}