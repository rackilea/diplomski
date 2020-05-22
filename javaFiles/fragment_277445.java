public class Main {
    public static void main(String[] args) {
        String str = "104,Jeans,B&B,pretty 105,Shoes,Nike,nice";
        final String join = String.join("\n", str.split(" "));
        System.out.println(join);
    }
}