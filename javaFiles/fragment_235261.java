StringTokenizer str = new StringTokenizer(<StringBufferObject>);
int count = 0;
int arrCount = 0;
StringBuffer temp;
String[] stringArr = new String[x];
while(str.hasMoreTokens()) {
    count++;
    if(count != 200) {
        temp.append(str.nextToken());
    }
    else {
    stringArr[arrCount] = temp;
    temp.delete(0,temp.length());
    count = 0;
    arrCount++;
}