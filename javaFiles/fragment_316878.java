import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Fileverifynanoha {
    private File file;
    private Path path;

    public Fileverifynanoha(String fp) {
        this.path = Paths.get(fp);
        this.file = path.toFile();
    }

    public void createFile()// this class wants to create a file, write something, and close it.
    {
        Charset charset = Charset.forName("UTF-8");
        String s = "Takamachi Nanoha. Shirasaki Tsugumi.!";
        BufferedWriter filewriter = null;
        try {
            filewriter = Files.newBufferedWriter(path, charset);
            filewriter.write(s, 0, s.length() - 1);
            filewriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }// end of this class

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args)// the main method will check if this file contains(created), if so, return exist. if not, return doesnt exist.
    {
        Fileverifynanoha f = new Fileverifynanoha("./txttest.txt");
        f.createFile();

        if (f.file.exists() && !f.file.isDirectory())// object does not create any real thing, therefore nothing true will return.
        {
            System.out.println("File exist.");
        } else {
            System.out.println("File does not exist.");
        }
    }
}