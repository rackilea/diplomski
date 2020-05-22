import java.io.*;
    public class main
  {
  public static void main() throws IOException
  {
    InputStreamReader isr=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(isr);
    int ch;
    int input;
    while(true)
    {
    System.out.println("Do you want to return to main screen. Press 1 for Yes, 0 for No");
    input = Integer.parseInt(br.readLine());
    if(input == 1)
    {
     ch=Integer.parseInt(br.readLine());
        switch(ch)
        {
             case 1:System.out.println("HI");
                    break;
        }
    }
    else
    {
    break;
    }
    }