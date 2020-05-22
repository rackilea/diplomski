//Regex for identifying string literals
         Pattern strRegex=Pattern.compile("\".*\"");

//Loop your array here to read code

//str is the temporary location of all the codes you have
//In mine, I have it inside a text area so I just typecasted it to string and start comparing there
//begins matching` for string literals that is in the strRegex
         Matcher m = strRegex.matcher(str) ;