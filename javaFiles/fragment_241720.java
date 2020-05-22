import java.io.BufferedWriter;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;

      public class Main {

        public static void main(String[] args) throws IOException {
            final Path filePath = Paths.get("D:/test.txt");
            final String sequenceToRemove = "foobar";

            /*
             * Read content from file
             */
            final String content = new String(Files.readAllBytes(filePath));

            /*
             * Remove content partially
             */
            final String modifiedContent = content.replace(sequenceToRemove, "");

            /*
             * Write modified content to file
             */
            try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
                writer.write(modifiedContent);
            }
        }
    }