public class Readline {
    public static void main(String[] args) throws java.io.IOException {
        System.out.print("What is your name?");
        java.io.BufferedReader stdin = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String name = stdin.readLine();
        System.out.println("Hello %s\n".format(name));
    }
}