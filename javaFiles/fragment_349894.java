public class Main {
    public static void main(String[] args) {
        try {
            String[] command = {"pngcrush", "-brute, "-e", "Optimize.png", "filename.png"};
            Runtime.getRuntime().exec(command);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}