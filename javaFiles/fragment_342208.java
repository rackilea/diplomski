int totalCharacters = textPane.getText().length(); 
int lineCount = (totalCharacters == 0) ? 1 : 0;

try {
   int offset = totalCharacters; 
   while (offset > 0) {
      offset = Utilities.getRowStart(textPane, offset) - 1;
      lineCount++;
   }
} catch (BadLocationException e) {
    e.printStackTrace();
}