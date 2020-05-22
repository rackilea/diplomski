public class Hex {
    public static void main(String[] args) {
        int firstNum  = 4;
        int secondNum = 15;

        System.out.println( Integer.toHexString( firstNum * 16 + secondNum ) );
        // Or if you find it easier to understand
        // System.out.println( Integer.toHexString( ( firstNum << 4 ) + secondNum ) );
    }
}