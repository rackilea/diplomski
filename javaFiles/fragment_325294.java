package my.pkg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyClass {
    public static void main(String[] args) throws IOException {
        Path path = Files.createTempFile("MyClass", "txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            System.getProperties()
                .entrySet()
                .stream()
                .forEach(
                    entry -> {
                        try {
                            writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                );
        }
    }
}