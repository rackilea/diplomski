import java.util.Scanner;  

public class stringCompair {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str = input.nextLine();
    for(int i=0 ; i < str.length();i++) {
        char key = str.charAt(i);
        countString(str, key);
    }

}

public static void countString(String str, char key) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == key)
            count++;
    }
    System.out.println("Number of Occurrence of "
            + key + " is " + count + " in string " + str);
}
}