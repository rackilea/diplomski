import java.util.Scanner;
public class Main {
public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    String s = "";
    System.out.println("Type a tweet: ");
    String input = keyboard.nextLine();
    int f = 0;
    int tweetLengthAllowed = 5;
    for(int i = 0; i < tweetLengthAllowed; ++i) { //Must be a for loop
        char c = input.charAt(i);

        if(c == 'a'|| c == 'e'|| c == 'i'|| c == 'o'|| c =='u' || 
            c == 'A' || c == 'E' ||  c == 'I' ||  c == 'O' || c == 'U') {

            f = 1;
            tweetLengthAllowed++; //Allows the loop to continue for one more interation
        } //end if
        else{
            s = s += c;
            f = 0;
        }//end else
    } //end for
    System.out.println(s);

} //end main
} //end class