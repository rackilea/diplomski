import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.stream.Stream;

public class FindWalk {

    public static void main(String[] args) throws IOException {
        File dataDir = new File("/tmp/usr/local");
        FileSystem fs = FileSystems.getDefault();
        String pattern = "/tmp/usr/local/*/test*/fol*";
        PathMatcher pathMatcher = fs.getPathMatcher("glob:" + pattern);
        FileVisitOption opts = FileVisitOption.FOLLOW_LINKS;
        try (Stream<Path> stream = Files.walk(dataDir.toPath(), opts)) {
            stream.filter(pathMatcher::matches)
                    .forEach(System.out::println);
        }
    }
}