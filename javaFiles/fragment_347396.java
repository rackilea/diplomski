import java.io.*;
    import java.util.*;

    public class Main{


      public static int printUpperCaseLetters(String s)
      {
        char[] ch = new char[s.length()];
        ch = s.toCharArray();
        int cap_count = 0;
        for(int i=0; i<ch.length; i++)
        {
          int val = (int)ch[i];
          if(val>=65 && val<=90)
          {
            cap_count++;
            System.out.println(ch[i]);
          }
        }
        return cap_count;
      }

      public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        // So this method returns you the capital letters count inside of the string
        int cap_count = printUpperCaseLetters(s);
      }
    }