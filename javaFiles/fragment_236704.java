public class JavahLauncher {

    public static void main(String[] args) {
        String original = System.getProperty("line.separator");
        System.setProperty("line.separator", "\n");
        try {
            com.sun.tools.javah.Main.run(args, new PrintWriter(System.out));
        }
        finally {
            System.setProperty("line.separator", original);
        }
    }
}