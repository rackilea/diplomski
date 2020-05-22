char[] origArr = str.toCharArray();
char[] destArr = new char[origArr.length];
int j = 0;
for (int i=0; i < origArr.length; i++) {
    char c = origArr[i];
    if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122))
       destArr[j++] = c;
}

String dest = new String(destArr, 0, j);