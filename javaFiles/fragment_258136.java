import java.util.Scanner;

public class shiftRows {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inputStr = "WVOGJTXQHUHXICWYYMGHTRKQHQPWKYVGLPYSPWGOINTOFOPMO";

        for (int i = 0 ; i < inputStr.length() ; i++){
            System.out.print(inputStr.charAt(i));
            if ((i + 1)%4 == 0) System.out.println();
        }
    }
}