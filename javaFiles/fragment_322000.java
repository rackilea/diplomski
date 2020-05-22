import java.util.*;
class HelloWorld {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt(); 
        ob.nextLine();
        int a = 0, c = 0;
        for (int j = 0; j < t; j++)
        {
            a = 0; c = 0;
            String str = ob.nextLine();
            if(str.trim().length()>0){
            String [] spstr = str.trim().split("\\s+");
            try
            {
                for (int i=0 ; i<spstr.length ; i++)
                {
                    c = c + Integer.parseInt(spstr[i]);
                }
                System.out.println(c);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
        }
    }
  }
}