public class Parent {

    private void init() {
        // ...
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object selected = combo.getSelectedItem();
                textField.setText(getTextBasedOnSelection(selected));
            }
        });
        // ...
    }

    /**
     * Returns the text to display when the given object is selected.
     * Subclasses may override this method to display what they want
     */
    protected String getTextBasedOnSelection(Object selected) {
        return selected.toString();
    }
    // ...
}