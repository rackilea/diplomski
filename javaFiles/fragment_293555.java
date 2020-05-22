// better code
String paragraph;
int j;
for (j = 0; j<lines; j++) {
     paragraph = buffer.readLine();
     outputStream.println(paragraph);    
}