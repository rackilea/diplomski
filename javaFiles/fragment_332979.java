public class Helper {

    private static int recursiveSumOfChars(String input){
        if(input.length() == 0) return 0;
        if(input.length() == 1) return input.codePointAt(0);
        else return input.codePointAt(0) + recursiveSumOfChars(input.substring(1));
    }

    public static void main(String[] args) {
        String test = "Red";
        System.out.println(recursiveSumOfChars(test));
    }
}