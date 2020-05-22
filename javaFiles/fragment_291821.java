import java.io.*;
import java.util.Scanner;


class HelloWorldApp {
public static int countPos(Scanner sc)
 {
  if(sc.hasNextInt())
   {
    int val = sc.nextInt();
    if (val > 0)
    {
        return countPos(sc) + 1;
    }
    else if (val =< 0)
    {
       return countPos(sc);
    }
    else {
        return 0;
    }
  }

  return 0;
}
    public static void main(String[] args) {
        System.out.println("--> " + countPos(new Scanner(System.in)));
    }
}