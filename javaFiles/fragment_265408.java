import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) throws IOException {
        String filename = "sets/Тех. тип = 0 Сет. = 1 Комплект 1.qr";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        String packageParameters = IOUtils.toString(inputStream, "UTF-8");
        inputStream.close();
        System.out.println(packageParameters); // prints 123
    }
}