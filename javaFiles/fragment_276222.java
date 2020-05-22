import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class decode { // <-- by convention, should be Decode
    public static void main(String[] args) {
        final Path indir = Paths.get("C:\\Temp\\crin");
        final Path outdir = Paths.get("C:\\Temp\\crout");
        final List<Path> contents = new ArrayList<>();
        try {
            Files.newDirectoryStream(indir).forEach(contents::add);
            for (final Path p : contents) {
                final byte[] arr = Files.readAllBytes(p);
                for (int i = 0; i < arr.length; i++)
                    arr[i] ^= 0x42;
                Files.write(outdir.resolve(p.getFileName()), arr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}