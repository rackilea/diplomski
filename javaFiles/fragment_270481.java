import java.util.Scanner;
public class Test {
    public static void main(String[]args) {
        boolean flag = false;
        Scanner kb = new Scanner(System.in);
        while(!flag) {
            String id = kb.next();//To get the next word
            flag = true;//by default its assumed to be valid input
            if(id.length() == 4) {
                for(int i = 0; i < 3; i++) {
                    if(!Character.isDigit(id.charAt(i))) {
                        flag = false;
                    }
                }
                if(!Character.isLetter(id.charAt(3))) {
                    flag = false;
                }
            }
            else {
                flag = false;
            }
            System.out.println("ID is "+ (flag == true?"Valid":"Invalid"));
        }
    }
}