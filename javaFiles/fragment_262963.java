import javax.swing.JOptionPane;

public class InputVerification {

   public static Integer parseInt( String value, int min, int max ) {
      try {
         final int iValue = Integer.parseInt( value );
         if(( min <= iValue ) && ( iValue <= max )) {
            return iValue;
         }
      }
      catch( final Throwable t ) {/**/}
      return null;
   }

   public static int getInteger( String message, int lowRange, int highRange ) {
      Integer intValue = null;
      do {
         final String userInput = JOptionPane.showInputDialog( message );
         intValue = parseInt( userInput, lowRange, highRange );
         if( intValue == null ) {
            JOptionPane.showMessageDialog(null,
               "Error! Please pick a number in [" +
               lowRange + ".." + highRange + "]" );
         }
      } while( intValue == null );
      return intValue.intValue();
   }

   public static void main( String[] args ) {
      getInteger("Hello!", 0, 10 );
   }
}