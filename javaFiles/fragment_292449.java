import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintUnique {
    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in)).lines().distinct()
            .forEach(System.out::println);
    }
}