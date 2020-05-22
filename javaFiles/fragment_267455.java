import java.io.*;
class tictactoe
{
    BufferedReader xy=new BufferedReader(new InputStreamReader(System.in));
    void accept()throws IOException
    {
        System.out.println("Enter your weapon X or O : ");
        char ch = xy.readLine().charAt(0);

        System.out.println("Your move:");
        String s=xy.readLine();
    }
}