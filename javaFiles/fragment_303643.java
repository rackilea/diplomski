void clampBuffer(int incomingDataSize)
{
   Document doc = textPane.getStyledDocument();
   int overLength = doc.getLength() + incomingDataSize - BUFFER_SIZE;

   if (overLength > 0)
   {
      doc.remove(0, over_length);
   }
}