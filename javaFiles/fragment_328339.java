public class Test {

    public static void main(String[] args) throws IOException {
        String line = "A|B|||";

        String[] zeroSplit = line.split("\\|");
        String[] negativeSplit = line.split("\\|",-1);

        System.out.println( "When split without parameter: " + zeroSplit.length );
        System.out.println( "When split with negative parameter: " + negativeSplit.length );
    }
}