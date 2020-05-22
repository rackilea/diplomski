public class MyProgram {

    public String expandString(String s, int v) { ... }

    public static void main(String[] args) { 
         String s = expandString(args[0], 1);  // ILLEGAL
         String s2 = args[0].expandString(1);  // ILLEGAL
    }
}