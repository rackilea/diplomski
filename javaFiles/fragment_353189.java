public String lastChars(String a, String b) 
{
    String firstA = "";
    String lastB = "";
    if(a.length() > 0) {
        firstA = a.substring(0,1);
    } else {
        firstA = "@";
    }
    if(b.length() > 0) {
        lastB = b.substring(b.length()-1);
    } else {
        lastB = "@";
    }
    return firstA + lastB;
}