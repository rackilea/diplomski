String a = "123456";
String b = "xxx-xx-x";

char[] cArray = b.toCharArray();
int aPos = 0; // create separate counter

for (int i = 0; i < b.length(); i++) {
    if (cArray[i] == '-') continue; // if skipping, do not increment aPos, continue
    cArray[i] = a.charAt(aPos);
    aPos++; // add counter when we used the charAt

    System.out.println(cArray);
}