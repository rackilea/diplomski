public class myRectangle
{
     private int length;
     private int width;

     public myRectangle(int inLength, int inWidth)
     {
         this.length = inLength;
         this.width = inWidth;
     }

     // the rest of your class
     public String toString()
     {
          return "[" + length + ", " + width + "]";
     }

     public static Rectangle parseString(String input)
     {
          int firstBracketIndex;
          int commaIndex;
          int lastBracketIndex;

          firstBracketIndex = 0;
          commaIndex = input.indexOf(",");
          lastBracketIndex = input.length() - 1;

          String aWidth = input.substring(firstBracketIndex, (commaIndex - 1));
          String aLength = input.substring((commaIndex + 2), lastBracketIndex);

          return new Rectangle(Integer.parseInt(aWidth), Integer.parseInt(aLength));
      }

 }