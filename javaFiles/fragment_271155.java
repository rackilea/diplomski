public class LetterCounter
{
   public static void main( String[] args ) throws FileNotFoundException
   {
      Scanner input = new Scanner( new File( "src/para1.txt" ) );
      char someChar = 'a';
      int count = 0;
      while ( input.hasNextLine() )
      {
         String answer = input.nextLine();
         answer = answer.toLowerCase();
         for ( int i = 0; i < answer.length(); i++ )
         {
            if ( answer.charAt( i ) == someChar )
            {
               count++;
            }
         }
         System.out.println( answer );
      }
      System.out.println( "a - " + count );
      input.close();
   }
}