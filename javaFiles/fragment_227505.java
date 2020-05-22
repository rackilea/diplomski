import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
            Scanner kb = new Scanner(System.in);
            String input="";
            int count = 0;
            while(true){
                    input = kb.nextLine();
                    if(input.equals("#"))
                        break;

                    int starCount=0;
                    for(count = 0; count < input.length(); count ++){
                            if(input.charAt(count)=='*'){
                                    starCount++;
                            }//if
                    }//for
                    System.out.println(starCount);
            }//while
        }//main
}