// Let's make it a double so we have something to work with.
double d = Double.parseDouble(tvResult.getText().toString());

String newText;
if (d % 1 == 0) { // See if the number is a whole number
    int i = (int) d; // If it is, cast it to an int to get rid of the decimal
    newText = String.valueOf(i); // Parse it to a string so we can clip off the end
    newText = newText.substring(0, newText.length() - 1); // Clip off the end
} else { 
    // If it's not a whole number, just parse it to a string.
    newText = String.valueOf(d);
    newText = newText.substring(0, newText.length() - 1); // Clip off the end
    if (newText.endsWith(".")) { 
        // If the number we clipped off was a tenth, clip off the decimal
        newText = newText.substring(0, newText.length() - 1);
    }
}

tvResult.setText(newText);