import java.util.Scanner;
public class question6 {

    public static void main(String[] args) {

        String str = "testing";
        boolean[] strBoolean = new boolean[str.length()];
        Scanner input = new Scanner(System.in);
        String test = "";
        int counter = 1;
        System.out.println("Java word guessing testing");

            // main for loop for guessing the letters
            while(true){
                if(allTrue(strBoolean)){
                    System.out.println("Congratulation!");
                    break;
                }else{
                    System.out.println("Key in one word character or your guessed word:");
                    test = input.nextLine();
                    // for loop for checking the boolean array
                    //and the rest of your code
                }
            }

    }
    public static boolean allTrue (boolean[] values) {
        for (int index = 0; index < values.length; index++) {
            if (!values[index]){
                return false;
            }
        }
        return true;
    }
}