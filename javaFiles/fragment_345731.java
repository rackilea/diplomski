public static int compare(String a, String b)
{
    int len = Math.min (a.length(),b.length());
    for (int i = 0; i<len; i++) {
        char cha = a.charAt(i);
        char chb = b.charAt(i);
        if (cha < chb) {
            return -1;
        } else if (cha > chb) {
            return 1; 
        }
    }
    if (a.length() < b.length())
        return -1;
    else if (a.length() > b.length())
        return 1;
    else
        return 0;
}