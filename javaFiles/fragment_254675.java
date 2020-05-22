private static final char OPEN = '{';
private static final char CLOSE = '}';

int openCount = 0;
int closeCount = 0;

... read the char and add to the string builder and then ...

   if(character == OPEN) {
      openCount++;
   } else if(character == CLOSE) {
      closeCount++;
      if(closeCount == openCount) {
          ... this means it's over, you can process the message
      }
   }