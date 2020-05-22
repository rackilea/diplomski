public class FileLoadingProcessor implements Processor {

@Override
public void process(Exchange exchange) throws Exception {
    String filename = exchange.getIn().getBody(String.class); // message body contains filename
    String filePath = exchange.getIn().getHeader("fileprocessor.filepath", String.class);

    if (filePath == null || filename == null) {
        // throw some custom exception
    }

    URI uri = new URI(filePath.concat(filename));
    File file = new File(uri);

    if (!file.exists()) {
        throw new FileNotFoundException(String.format("File %s not found on %s", filename, filePath));
    }

    exchange.getIn().setBody(file);
}