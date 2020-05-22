byte[] readBuf =(byte[]) msg.obj);
String readMessage = newString(readBuf,0,msg.arg1); //You create the string here
String final=""; //new string to be parsed
for(int i = 0; i<readMessage.length(); i++){ 
    final+=""+(int)readMessage.charAt(i); // get the charAt(i) cast it to int and give it to the string
}
return Integer.parseInt(final)*factor; //return the int multiplied by 3