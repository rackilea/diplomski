public class Practice {
    public static void main(String[] args){
       System.out.println( min(3, -2, 7));
       System.out.println(min(19, 27, 6));

    }

    public static int min(int number1, int number2, int number3){
        return Math.min(number1, Math.min(number2, number3));


    }
}