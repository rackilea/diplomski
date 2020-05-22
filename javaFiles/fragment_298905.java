public class ClassContainingTextFields {
    private final ArrayList<JTextField> textFields = new ArrayList<>();

    // ... inside the method that creates the fields ...
        for (int i = 0; i < 9; i++) {
            JTextField field = new JTextField(3);
            //  .. do other setup 
            textFields.add(field);
        }


    /**
     * This method returns true if and only if all the text fields are empty
     **/
    public boolean allFieldsEmpty() {
        for (JTextField textbox : textFields) {
            if (! textbox.getText().trim().isEmpty() ) {
                return false;   // one field is non-empty, so we can stop immediately
            }
        }
        return true;  // every field was empty (or else we'd have stopped earlier)
    }
    // ....
}