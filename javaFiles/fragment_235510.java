import java.io.*;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader in;
        in = new BufferedReader (new InputStreamReader (System.in));
        boolean again=true;
        String response;

        while (again) {
            System.out.println("Enter a letter to find it's order in the alphabet");
            response = in.readLine();
            if (response.length() > 0) {
                char theLetter = response.charAt(0);

                System.out.println(theLetter + " is the " + convertLetter(theLetter) + "th letter of the alphabet");
                System.out.println("want to play again?");

                response = in.readLine();
                if (response.length() > 0 && response.charAt(0)=='n') {
                    again=false;
                }
            }
        }
        System.out.println("end program");
    }

    public static int convertLetter(char TheLetter) {
        return (TheLetter - 'a') + 1;
    }

}