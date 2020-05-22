public class validatePostalCodeTest 
{
   public static void main (String[] args) throws java.lang.Exception
   {

      Scanner kb = new Scanner(System.in);
      System.out.println("Please enter postalcode:");
      String posCode = kb.nextLine();

       if (posCode.length() > 7) 
           System.out.println("\nInvalid");
       if (posCode.length() < 6) 
           System.out.println("\nInvalid");    
       if (posCode.length()== 7){
           boolean valid = true;

            char a = posCode.charAt(0);
            char b = posCode.charAt(2);
            char c = posCode.charAt(4);
            char d = posCode.charAt(1);
            char e = posCode.charAt(5);
            char f = posCode.charAt(6);
            char g = posCode.charAt(3);
            if(! Character.isLetter(a))
                valid = false; 
            else if (! Character.isLetter(b))
                valid = false;
            else if (! Character.isDigit(c))
                valid = false;
            else if (! Character.isDigit(d))
                valid = false;
            else if (! Character.isLetter(e))
                valid = false;
            else if (! Character.isDigit(f))
                valid = false;
            else if (! Character.isWhitespace(g))
                valid = false;

           if (valid) System.out.println("\nValid");
           else System.out.println("\nInvalid");
       }
       if (posCode.length()== 6){
           boolean valid = true;

            char a = posCode.charAt(0);
            char b = posCode.charAt(2);
            char c = posCode.charAt(4);
            char d = posCode.charAt(1);
            char e = posCode.charAt(3);
            char f = posCode.charAt(5);
            if(! Character.isLetter(a))
                valid = false; 
            else if (! Character.isLetter(b))
                valid = false;
            else if (! Character.isLetter(c))
                valid = false;
            else if (! Character.isDigit(d))
                valid = false;
            else if (! Character.isDigit(e))
                valid = false;
            else if (! Character.isDigit(f))
                valid = false;


           if (valid) System.out.println("\nValid");
           else System.out.println("\nInvalid");
       }
       System.out.println("Program ending due to end-of-file");
   }
}