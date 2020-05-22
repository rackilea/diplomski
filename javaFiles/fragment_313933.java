String sa1 = "\"\"\"JBL@gmail.com\"\" <JBL@gmail.com>\"";
String email = "";

Pattern pattern = Pattern.compile("<(.*?)>");
Matcher matcher = pattern.matcher(sa1);
while (matcher.find()) {
    // Is a match found? 
    if (!matcher.group(1).equals("")) { 
        // There is so place the match into the 
        // email variable.
        email = matcher.group(1); 
    }
}
// Display the E-Mail Address in Console Window.
System.out.println("E-Mail Address is:  " + email);