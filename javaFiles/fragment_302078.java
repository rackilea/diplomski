String text = // Text from the file...

int letterCount = text.length();
int wordCount = text.split("\\s").length;
String result = "[insert file name here] has " + letterCount + " characters and " + wordCount + " words";

// A JTextArea you created eailer
textArea.setText(result);