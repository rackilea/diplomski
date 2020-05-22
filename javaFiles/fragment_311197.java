import javax.imageio.spi.IIORegistry;
import javax.imageio.spi.ImageWriterSpi;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        IIORegistry registry = IIORegistry.getDefaultInstance();
        Iterator<ImageWriterSpi> serviceProviders = registry.getServiceProviders(ImageWriterSpi.class, false);
        while(serviceProviders.hasNext()) {
            ImageWriterSpi next = serviceProviders.next();
            System.out.printf("description: %-27s   format names: %s%n",
                    next.getDescription(Locale.ENGLISH),
                    Arrays.toString(next.getFormatNames())
            );
        }
    }
}