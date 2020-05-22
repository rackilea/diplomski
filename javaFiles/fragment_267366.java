char[] realString = "http://@50stackoverflow.com/questions/@50724043/@50xyz.html".toCharArray();
String newString = "";
for (int i = 0; i < realString.length; i++) {
    if (i<realString.length-2 && realString[i] == '@' && realString[i+1] == '5' && realString[i+2] == '0') {
        newString = newString + " ";
        i=i+3;
    } else {
        newString = newString + realString[i];
    }
}
System.out.println(newString);