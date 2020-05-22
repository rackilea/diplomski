private JTextField txtValues = new JTextField("25, 50, 80, 90"); 

// Strip the whitespaces using a regex since they will throw errors
// when converting to integers
String values = txtValues.getText().replaceAll("\\s","");

// Get the inserted values of the text field and use the comma as a separator.
// The values will be returned as a string array
private String[] strValues = values.split(",");

// Initialize int array
private int[] intValues = new int[strValues.length()];
// Convert each string value to an integer value and put it into the integer array
for(int i = 0; i < strValues.length(); i++) {
    try {
       intValues[i] = Integer.parseInt(strValues[i]);
    } catch (NumberFormatException nfe) {
       // The string does not contain a parsable integer.
    }

}