public class Demo {
    public static void main(String[] s) {
        String[] args = "s3://REF3/ca209_040/aesae.csv".split("/");
        System.out.println(args[3] + " ,  " + args[4]);
    }
}