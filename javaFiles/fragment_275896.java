import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetAllFilesInDirectory {

    public static void main(String[] args) throws IOException {

        String filter = "BCM";

        List<File> files = listFiles("/tmp", new CustomerFileFilter(filter));
        for (File file : files) {
            System.out.println("file: " + file.getCanonicalPath());
        }
    }

    private static List<File> listFiles(String directoryName, CustomerFileFilter fileFilter) {
        File directory = new File(directoryName);
        List<File> files = new ArrayList<>();

        // Get all files from a directory.
        File[] fList = directory.listFiles(fileFilter);
        if(fList != null) {
            for (File file : fList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    files.addAll(listFiles(file.getAbsolutePath(), fileFilter));
                }
            }
        }
        return files;
    }
}

class CustomerFileFilter implements FileFilter {

    private final String filterStartingWith;

    public CustomerFileFilter(String filterStartingWith) {
        this.filterStartingWith = filterStartingWith;
    }
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.isFile() && file.getName().startsWith(filterStartingWith);
    }
}