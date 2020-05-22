public class Test {
    public static void main(String[] args) throws Exception {
        Integer in2 = 897387483;
        String hex = Integer.toHexString(in2);
        System.out.println(hex);
        System.out.println(hex.substring(hex.length()-4, hex.length()));
    }
}