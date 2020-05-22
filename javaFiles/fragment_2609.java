import java.io.*;


public class rot13

{

public static void main (String [] args) throws IOException
{
BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));// Buffered Reader reads the number inputed 

String key [] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
String keyA [] = {"N","O","P","Q","R","S","T","U","V","W","X","Y","Z","A","B","C","D","E","F","G","H","I","J","K","L","M"};
String letter;

System.out.println("Enter a phrase:");
String phrase = myInput.readLine();
int y = 0, i = 0;
while ( y <= phrase.length()){

    letter = Character.toString(phrase.charAt(y));
    //Each time you go throught the first loop, you are comparing your actual position in the string and i
    //But as you don't reset i back to 0, you only try to compare your previous index and your actual index : if y == 3, so i takes only the values 2 and 3
    //Moreover, when y > 26, you try to access the key array outside of its bounds 
    while(i <= y){
        // letter is a string so you should be using equals
        if (letter != key[i]){
            // You are putting the value at the i index in the i index, so you do basically nothing with this line
            keyA [i] = keyA[i];
        }
        i++;
    }
    System.out.println(keyA [i]);
    y++;
    } 
}