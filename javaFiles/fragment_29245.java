import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FolderPath {

    private static FileFilter onlyDirectories = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };

    public static void main(String[] args) {
        File currentDir = new File("C:\\test"); // current directory
        displayDirectoryContents(currentDir);
    }

    public static void displayDirectoryContents(File dir) {
        StringBuilder sb1 = new StringBuilder("[");
        doDisplayDirectoryContents(dir, sb1);
        if (sb1.length() > 1) {
            sb1.deleteCharAt(sb1.length() - 1);
        }
        sb1.append("]");
        System.out.println(sb1);
    }

    private static void doDisplayDirectoryContents(File dir, StringBuilder sb1) {
        File[] files = dir.listFiles(onlyDirectories);

        if (files != null) {
            for (File file : files) {
                try {
                    sb1.append("{\"JSONKEY\":\"" + file.getCanonicalPath() + "\"},");
                    doDisplayDirectoryContents(file, sb1);
                } catch (IOException e) {
                    e.printStackTrace();
                }   
            }
        }
    }
}