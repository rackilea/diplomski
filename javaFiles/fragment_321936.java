import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException  {
        createTestCountFiles(new File("C:\\Test Folder"), "C:\\testlines");
    }

    public static void createTestCountFiles(File dir, String newPath) throws IOException {

        File newDir = new File(newPath);
        if (!newDir.exists()) {
            newDir.mkdir();
        }

        for (File file : dir.listFiles()) {
            int count = lineCount(file.getPath());
            File newFile = new File(newPath+"\\"+file.getName());
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            try (FileWriter fw = new FileWriter(newFile)) {
                fw.write("" + count + "");
            }
        }
    }

    private static int lineCount(String file) throws IOException  {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (reader.readLine() != null) lines++;
        }
        return lines;
    }
}