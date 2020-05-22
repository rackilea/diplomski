import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sample {
    public static void main(String[] args) throws IOException {
        if(args.length == 2)
        {
            doFileStuff(args[0],args[1]);
        }
        else {
            doFileStuff("in.txt","out.txt");
        }
    }

    public static void doFileStuff(String input_filename, String output_filename) throws IOException {

        if(!Files.exists(Paths.get(input_filename)))
        {
            System.err.println("file not exist: " + input_filename);
            return;
        }

        if(!Files.exists(Paths.get(output_filename)))
        {
            System.err.println("file still exist, do not overwrite it: " + output_filename);
            return;
        }

        String content = new String(Files.readAllBytes(Paths.get(input_filename)));

        content += "\nHas added something";

        Files.write(Paths.get(output_filename), content.getBytes(StandardCharsets.UTF_8));
    }
}