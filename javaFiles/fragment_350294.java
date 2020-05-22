Log.d("connection", Integer.toString(inSize)); // the first 2 bytes are the size of the message
byte[] inData = new byte[inSize];//allocate space for the entire message

int count = 0;
while (count < inSize)
{
   int len = in.read(inData, count, inSize - count);
   count += len;
}
String resp = new String(inData, 0, inSize, "UTF-8");//cast into a String
Log.d("connection", resp);