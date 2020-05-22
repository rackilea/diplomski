public class Main {
    public static void main(String[] args) {
            System.out.println(removeDigit(23219));
    }

    public static int removeDigit(int n) {
        if (Math.abs(n) < 10) {
            return n;
        } 
        return removeDigit(n/10);
    }
}