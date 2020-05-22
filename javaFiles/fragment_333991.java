public class Main {


    public static void main(String[] args) {

        int count=0;
        for (int i = 0; i < 1_000_000; i++) {
            if (isDoublePalindrome(""+i)) {
                count+=i;
            }
        }

        System.out.println(count);

    }

     public static boolean isPalindrome(String N){
        return new StringBuilder(N).reverse().toString().equals(""+N);
    }

    public static String toBinary(String N){

        return Long.toBinaryString(Long.parseLong(N));
    }

    public static boolean isDoublePalindrome(String N){

        if(isPalindrome(N) && isPalindrome(toBinary(N))) return true;
        return false;
    }

}