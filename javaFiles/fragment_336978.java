import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("/bin/ls");
        } catch (IOException ignored) {}
    }
}