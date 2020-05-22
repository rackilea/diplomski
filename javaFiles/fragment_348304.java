public class Main {
    private static PrintStream ps;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try { 
            // Don't declare `ps` here; just initialize it...
            ps = new PrintStream("brooklynCarpet.txt"); 
            // remaining logic of `main` below...
        } catch (FileNotFoundException fnf){
            System.out.println("Unexpected exception: " + fnf.toString());
        }
    }
    // ...
 }