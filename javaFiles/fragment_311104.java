int buffersize = 1000;
int offset = 0;
byte[] fileData = new byte[buffersize];

int numBytesRead;
String string;
while((numBytesRead = in.read(fileData,offset,buffersize)) != -1)
{
 string = getBinary(fileData);//Adjust this so it can work with a whole array of bytes at once
 out.write(string); 
 offset += numBytesRead;
 }