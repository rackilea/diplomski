import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GetFilesFromDirectory {

    public static void main(String[] args) {
        String folderPath = "/Users/js/test";
        int depth = 1;

        List<String> DocsList = getFiles(folderPath, depth);
        String[] Docs = new String[DocsList.size()];

        for (int i = 0; i < DocsList.size(); i++) {
            Docs[i] = DocsList.get(i);
        }

        //for check
        for (String Doc : Docs) {
            System.out.println(Doc);
        }
    }

    private static List<String> getFiles(String pathToSearch, int depth) {
        List<String> files = new ArrayList<>();
        try {
            Stream<Path> paths = Files.find(Paths.get(pathToSearch), depth, (path, attributes) -> attributes.isRegularFile());
            paths.forEach(path -> files.add(path.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }
}