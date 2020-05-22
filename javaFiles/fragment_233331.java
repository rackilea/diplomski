public class ConvertNegative {
    public static void main (String [] args) {
        int userNum = 0;

        if (userNum >= 0)
            System.out.println("Non-negative");
        else{
            System.out.println("Negative; converting to 0");
            userNum = 0;
            System.out.format("Final: %d", userNum);
            System.out.println(""); 
        }
        //return; -> There is no need for the return as the main method has no return value.
    }
}