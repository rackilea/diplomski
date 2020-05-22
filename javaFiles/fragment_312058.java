@SpringBootApplication
public class DemoApplication {

public static void main(String[] args) {

    SpringApplication.run(DemoApplication.class, args);

    final String baseFolder = "folder1";
    try {
    Path pathBase = Paths.get(ClassLoader.getSystemResource(baseFolder).toURI());

        Files.walk(pathBase.resolve("folder2/folder3"))
                .filter(Files::isRegularFile)
                .forEach(f -> System.out.println(pathBase.relativize(Paths.get(f.toUri()))));
    } catch (IOException e) {
        e.printStackTrace();
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }

 }}