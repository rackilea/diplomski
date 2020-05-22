// String newText = "" ;
StringBuilder newText = new StringBuilder();
// ...
// newText += lines[i] ;
newText.append(lines[i]);
// ...
// outputLog.setText(newText);
outputLog.setText(newText.toString());