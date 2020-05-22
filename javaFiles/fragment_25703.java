import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class FindWalkFileTree {

    public static class Finder implements FileVisitor<Path> {
        private final PathMatcher matcher;

        Finder(String pattern) {
            final FileSystem fs = FileSystems.getDefault();
            matcher = fs.getPathMatcher("glob:" + pattern);
        }

        void find(Path file) {
            if (matcher.matches(file)) {
                System.out.format("%s%n", file);
            }
        }

        @Override
        public FileVisitResult visitFile(Path file, 
                BasicFileAttributes attrs) {
            find(file);
            return CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, 
                IOException exc) {
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            return CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, 
                BasicFileAttributes attrs) throws IOException {
            find(dir);
            return CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Path searchDir = Paths.get("/tmp/usr/local");
        String pattern = "/tmp/usr/local/*/test*/fol*";
        EnumSet<FileVisitOption> opts = EnumSet.of(
                FileVisitOption.FOLLOW_LINKS);
        Finder finder = new Finder(pattern);
        Files.walkFileTree(searchDir, opts, Integer.MAX_VALUE, finder);
    }
}