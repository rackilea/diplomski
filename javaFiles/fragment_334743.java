package dllportable;

    import java.io.File;
    import java.io.IOException;
    import java.net.URISyntaxException;
    import java.net.URL;
    import java.nio.file.Files;

    public class dllportable {

        public static void main(String[] args) throws URISyntaxException, IOException {
            URL url=dllportable.class.getClassLoader().getResource("config.dll");
            System.out.println(url.toURI());
            Files.copy(new File(url.toURI()).toPath(), new File("C:\\haroon\\config.dll").toPath());
// Then your Operations on the DLL
        }

    }