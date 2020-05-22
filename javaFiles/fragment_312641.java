public class Test{
    public static void main(String[] args) {
        String bin1 = "11011100000000010001000000000000";
        String bin2 = "01100100001000010001000000000000";

        long dec = Long.parseLong(bin1, 2);
        String hex = Long.toString(dec, 16);

        System.out.println(hex);
    }
}