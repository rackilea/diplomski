import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class CopyFiles {
    public static void copyFiles(Path src, Path dest, PathMatcher matcher, CopyOption... copyOptions) throws IOException {
        // Argument validation
        if (!Files.isDirectory(src)) {
            throw new IllegalArgumentException("Source '" + src + "' is not a directory");
        }
        if (!Files.isDirectory(dest)) {
            throw new IllegalArgumentException("Destination '" + dest + "' is not a directory");
        }
        Objects.requireNonNull(matcher);
        Objects.requireNonNull(copyOptions);

        BiPredicate<Path, BasicFileAttributes> filter = (path, attributes) -> attributes.isRegularFile() && matcher.matches(path);

        // Use try-with-resources to close stream as soon as it is not longer needed
        try (Stream<Path> files = Files.find(src, Integer.MAX_VALUE, filter)) {
            files.forEach(file -> {
                Path destFile = dest.resolve(src.relativize(file));
                try {
                    copyFile(file, destFile, copyOptions);
                }
                // Stream methods do not allow checked exceptions, have to wrap it
                catch (IOException ioException) {
                    throw new UncheckedIOException(ioException);
                }
            });
        }
        // Wrap UncheckedIOException; cannot unwrap it to get actual IOException 
        // because then information about the location where the exception was wrapped 
        // will get lost, see Files.find doc
        catch (UncheckedIOException uncheckedIoException) {
            throw new IOException(uncheckedIoException);
        }
    }

    private static void copyFile(Path srcFile, Path destFile, CopyOption... copyOptions) throws IOException {
        Path destParent = destFile.getParent();

        // Parent might be null if dest is empty path
        if (destParent != null) {
            // Create parent directories before copying file
            Files.createDirectories(destParent);
        }

        Files.copy(srcFile, destFile, copyOptions);
    }

    public static void main(String[] args) throws IOException {
        Path srcDir = Paths.get("path/to/src");
        Path destDir = Paths.get("path/to/dest");
        // Could also use FileSystem.getPathMatcher
        PathMatcher matcher = file -> file.getFileName().toString().endsWith(".txt");
        copyFiles(srcDir, destDir, matcher);
    }
}