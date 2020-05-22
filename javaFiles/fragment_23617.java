import java.io.File;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        File file = exchange.getIn().getBody(File.class);
        processFile(file);
    }

    private void processFile(File file) {
        //TODO process file
    }
}