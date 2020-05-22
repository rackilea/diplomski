import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class MainProgram
    {

        public static void main ( String [ ] args )
        {
            List < Movie > movieList = new ArrayList < Movie > ( );

            for(int i = 1; i <= 4; i++ )
            {

                int screen = i;
                String name = inputString ( "Film for screen "+(i));
                int hour = inputInt ("what hour does it start?");
                int min = inputInt ("what min does it start?");

                Movie movie = new Movie ( name , hour , min , screen );
                movieList.add ( movie );
            }

            print("Cineworld Movies For Tonight");

            for( Movie movie : movieList)
            {
                print ( "" );
                print ( Integer.toString ( movie.getScreen ( ) ));
                print (movie.getName ( ));
                print (Integer.toString ( movie.getHour ( ) ));
                print ( Integer.toString ( movie.getMin ( ) ));
            }

        }

        public static String inputString ( String message )
        {
            Scanner scanner = new Scanner ( System.in );
            print ( message );
            String answer = scanner.nextLine ( );
            return answer;
        }

        public static String print ( String message )
        {
            System.out.println ( message );
            return message;
        }

        public static int inputInt ( String message )
        {
            int number = Integer.parseInt ( inputString ( message ) );
            return number;
        }


    }