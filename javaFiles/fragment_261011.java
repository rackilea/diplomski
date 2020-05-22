import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Give me a String:");
        String s1 = scan.nextLine();

        System.out.println(countSubstrings(s1));

    }

    public static int countSubstrings(String s1){
        int index = 0;
        int count = 0;

        while (index < s1.length()-2) {
            if(s1.charAt(index) == '.' && s1.charAt(index+1) != '.'){
                index++;
            }
            else if (index+2 < s1.length() && s1.charAt(index) == 'x' && s1.charAt(index + 1) == 'y'
                    && s1.charAt(index + 2) == 'z') {
                count++;
                index+=2;
            }
            index++;
        }
        return count;
    }

}