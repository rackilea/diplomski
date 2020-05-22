BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
char[] msgsReadArray = new char[streamingArrayMaxCapacity];
int currentCharsCount = 0;
int currOffset = 0;
int currMsgBytesLength = 0;
while ((currentCharsCount = reader.read(msgsReadArray, currOffset , streamingArrayMaxCapacity - currOffset)) != -1 ) {
     String lastStreamingMsg = new String(msgsReadArray, 0, currMsgBytesLength);
     currOffset += currentCharsCount;
}