String source = "1,2,3,4,5";
String[] temp = source.split(","); // this split your String with ,
byte[] bytesArray = new byte[temp.lenght];
int index = 0;
for (String item: temp) {
   bytesArray[index] = Byte.parseByte(item);
   index++;
}