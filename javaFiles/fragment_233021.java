import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSorter {

    // This sorts from old to young and from big to small
    Comparator<Path> timeSizeComparator = (Path o1, Path o2) -> {
        int sorter = 0;
        try {
            FileTime lm1 = Files.getLastModifiedTime(o1);
            FileTime lm2 = Files.getLastModifiedTime(o2);
            if (lm2.compareTo(lm1) == 0) {
                Long s1 = Files.size(o1);
                Long s2 = Files.size(o2);
                sorter = s2.compareTo(s1);
            } else {
                sorter = lm1.compareTo(lm2);
            }
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
        return sorter;
    };

    public String[] getSortedFileListAsArray(Path dir) throws IOException {
        Stream<Path> stream = Files.list(dir);
        return stream.sorted(timeSizeComparator).
                map(Path::getFileName).map(Path::toString).toArray(String[]::new);
    }

    public List<String> getSortedFileListAsList(Path dir) throws IOException {
        Stream<Path> stream = Files.list(dir);
        return stream.sorted(timeSizeComparator).
                map(Path::getFileName).map(Path::toString).collect(Collectors.
                toList());
    }

    public String[] sortByDateAndSize(File[] fileList) {
        Arrays.sort(fileList, (File o1, File o2) -> {
            int r = Long.compare(o1.lastModified(), o2.lastModified());
            if (r != 0) {
                return r;
            }
            return Long.compare(o1.length(), o2.length());
        });
        String[] fileNames = new String[fileList.length];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = fileList[i].getName();
        }
        return fileNames;
    }

    public List<String> getSortedFile(Path dir) throws IOException {
        return Files.list(dir).map(PathInfo::new).sorted().map(p -> p.getFileName()).collect(Collectors.toList());
    }

    static class PathInfo implements Comparable<PathInfo> {
        private final String fileName;
        private final long modified;
        private final long size;

        public PathInfo(Path path) {
            try {
                fileName = path.getFileName().toString();
                modified = Files.getLastModifiedTime(path).toMillis();
                size = Files.size(path);
            } catch (IOException ex) {
                throw new UncheckedIOException(ex);
            }
        }

        @Override
        public int compareTo(PathInfo o) {
            int cmp = Long.compare(modified, o.modified);
            if (cmp == 0)
                cmp = Long.compare(size, o.size);
            return cmp;
        }

        public String getFileName() {
            return fileName;
        }
    }

    public static void main(String[] args) throws IOException {
        // File (io package)
        File f = new File("C:\\Windows\\system32");
        // Path (nio package)
        Path dir = Paths.get("C:\\Windows\\system32");

        FileSorter fs = new FileSorter();

        long before = System.currentTimeMillis();
        String[] names = fs.sortByDateAndSize(f.listFiles());
        long after = System.currentTimeMillis();
        System.out.println("Run time of Arrays.sort: " + ((after - before)));

        long before2 = System.currentTimeMillis();
        String[] names2 = fs.getSortedFileListAsArray(dir);
        long after2 = System.currentTimeMillis();
        System.out.println("Run time of Stream.sorted as Array: " + ((after2 - before2)));

        long before3 = System.currentTimeMillis();
        List<String> names3 = fs.getSortedFileListAsList(dir);
        long after3 = System.currentTimeMillis();
        System.out.println("Run time of Stream.sorted as List: " + ((after3 - before3)));
        long before4 = System.currentTimeMillis();
        List<String> names4 = fs.getSortedFile(dir);
        long after4 = System.currentTimeMillis();
        System.out.println("Run time of Stream.sorted as List with caching: " + ((after4 - before4)));
    }
}