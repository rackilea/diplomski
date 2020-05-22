import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity  {

public static void main(String[] args) {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    String ip= null;
    try {

        String next;
        do
       {
          next=br.readLine().toString();
           ip+=next;
       }
      while(!next.equalsIgnoreCase("}"));
    } catch (IOException e) {
        e.printStackTrace();
    }


    System.out.println("You have entered:");
    System.out.println(""+ip);

}
}