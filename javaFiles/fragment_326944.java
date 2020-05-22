// New Code Array
String[] newCode = new String[originalCode.length];

for (int i=0; i<originalCode.length; i++) {
 // New Code Line
 String newCodeLine = originalCode[i];

 // Iterate through all words that need to be replaced
 for (int j=0; j<listOfThingsToReplace.length; j++) {
  
  // String to replace
  String strToReplace = listOfThingsToReplace[j];
  
  // String to replace with
  String strToReplaceWith = (j >= listOfReplacingThings.length) ? "" : listOfReplacingStrings[j];
  
  // If there is a string to replace with
  if (strToReplaceWith != "") {
   
   // then replace all instances of that string
   newCodeLine = newCodeLine.replaceAll(strToReplace, strToReplaceWith);
  }  
 }
 
 // Assign the new code line to our new code array
 newCode[i] = newCodeLine;
}