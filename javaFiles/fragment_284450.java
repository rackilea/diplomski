public class Assignment6 {
public static void main(String[]args){
   Scanner scan = new Scanner( System.in );
   boolean notValid = true;
   String  input;
   do{
           System.out.print( "Enter a number to Convert > "  );
           input = scan.nextLine( );
           if(!input.isEmpty())
             notValid = false;

    } while ( notValid );

   } 
}