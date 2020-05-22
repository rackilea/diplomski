textField = new JTextField();
    // set document listener
    textField.getDocument().addDocumentListener(new MyListener());
    // get the preferences associated with your application
    Preferences prefs = Preferences.userRoot().node("unique_string_representing_your_preferences");
    // load previous value
    textField.setText(prefs.get("your_preference_unique_key", ""));

class MyListener implements DocumentListener {

    @Override
    public void changedUpdate(DocumentEvent event) {
        final Document document = event.getDocument();
        // get the preferences associated with your application
        Preferences prefs = Preferences.userRoot().node("unique_string_representing_your_preferences");
        try {
            // save textfield value in the preferences object
            prefs.put("your_preference_unique_key", document.getText(0, document.getLength()));
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent arg0) {
    }

    @Override
    public void removeUpdate(DocumentEvent arg0) {
    }
}