import java.util.Scanner;
        public class test
        {      
      public static void main(String args[]) throws Exception
        {
            Scanner scan1=new Scanner(System.in);
            String array[]=new String[10];
            String ins_check="y";
            int columns=9;
            do {
                for (int o = 0; o <= columns; o++) {
                    System.out.printf("Enter the value for array[%s]",o);
                    array[o] = scan1.nextLine();
                }
                System.out.println("record inserted");
                System.out.println("Do you want to insert again?(y/n)");
                ins_check= scan1.nextLine();
            }while(ins_check.equals("y"));
            System.out.println("end");
       }
    }