@Override
public void characters(char[] ch, int start, int length)
{
   if(length == 0) return;
   int end = (start + length) - 1;
   while(char[start] <= '\u0020')
   {
       if(start == end) return;
       start++;
       length--;
   }
   while(char[end] <= '\u0020')
   {
       if(end == start) return;
       length--;
       end--;
   }
   currentText.append(ch, start, length);
}