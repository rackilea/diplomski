import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.zip.*;

public class FindDuplicates {
    public static void main(final String... args) throws IOException {
        findDuplicates(argsOrCurrentDirectory(args));
    }

    private static String[] argsOrCurrentDirectory(final String... args) {
        return args.length == 0 ? new String[] {"."} : args;
    }

    private static void findDuplicates(final String... paths) throws IOException {
        final Stream<Path> allFilesInPaths = find(paths);

        final Map<Long, List<Path>> filesBySize = allFilesInPaths.collect(Collectors.groupingByConcurrent(path -> path.toFile().length()));
        final Stream<Path> filesWithNonUniqueSizes = getValueStreamFromDuplicates(filesBySize);

        final Map<Long, List<Path>> filesByChecksum = filesWithNonUniqueSizes.collect(Collectors.groupingBy(FindDuplicates::getChecksum));
        final Stream<Path> filesWithNonUniqueChecksums = getValueStreamFromDuplicates(filesByChecksum);

        filesWithNonUniqueChecksums.forEach(System.out::println);
    }

    private static Stream<Path> toPaths(final String... pathnames) {
        return Arrays.asList(pathnames).parallelStream().map(FileSystems.getDefault()::getPath);
    }

    private static Stream<Path> find(final String... pathnames) {
        return find(toPaths(pathnames));
    }

    private static Stream<Path> find(final Stream<Path> paths) {
        return paths.flatMap(FindDuplicates::findSinglePath);
    }

    private static Stream<Path> findSinglePath(final Path path) {
        try {
            return Files.find(path, 127, ($, attrs) -> attrs.isRegularFile());
        } catch (final IOException e) {
            System.err.format("%s: error: Unable to traverse path: %s%n", path, e.getMessage());
            return Stream.empty();
        }
    }

    public static <V> Stream<V> getValueStreamFromDuplicates(final Map<?, List<V>> original) {
        return original.values().parallelStream().filter(list -> list.size() > 1).flatMap(Collection::parallelStream);
    }

    public static long getChecksum(final Path path) {
        try (final CheckedInputStream in = new CheckedInputStream(new BufferedInputStream(new FileInputStream(path.toFile())), new CRC32())) {
            return tryGetChecksum(in);
        } catch (final IOException e) {
            System.err.format("%s: error: Unable to calculate checksum: %s%n", path, e.getMessage());
            return 0L;
        }
    }

    public static long tryGetChecksum(final CheckedInputStream in) throws IOException {
        final byte[] buf = new byte[4096];
        for (int bytesRead; (bytesRead = in.read(buf)) != -1; );
        return in.getChecksum().getValue();
    }
}