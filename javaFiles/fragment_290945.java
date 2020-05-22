String str1 = "", str2 = "", str3 = "", str4 = "", str5 = "";
String str = "123|apple|apple|apple|dog$";
StringTokenizer strString = new StringTokenizer(str, "|");
int k = 0;
while (strString.hasMoreElements()) {
    if (k == 0)
        str1 = strString.nextToken();
    else if (k == 1)
        str2 = strString.nextToken();
    else if (k == 2) {
        str3 = strString.nextToken();
    } else if (k == 3) {
        str4 = strString.nextToken();
    } else if (k == 4) {
        str5 = strString.nextToken();
        break;
    }
    k = k + 1;
}
System.out.println(str1);
System.out.println(str2);
System.out.println(str3);
System.out.println(str4);
System.out.println(str5);