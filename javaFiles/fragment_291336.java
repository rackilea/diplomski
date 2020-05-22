String cmd = "1141126";
int len = cmd.length();
int day = Integer.parseInt( cmd.substring( len - 2 ) ); 
int month = Integer.parseInt( cmd.substring( len - 4, len - 2 ) ); 
int year = 1900 + Integer.parseInt( cmd.substring( 0, len - 4 ) ); 
String mdc = month + "/" + day + "/" + year;