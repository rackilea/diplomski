import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import java.io.File;
import java.net.ConnectException;

public class JODConv {  
    public static void main(String[] args) throws ConnectException {

        if (args.length!=2) {
            System.out.println("Usage:\nJODConv <file-to-convert> <pdf-file>");
            System.exit(0);
        }

        String sourceFilePath = args[0];
        String destFilePath = args[1];


        File inputFile = new File(sourceFilePath);
        File outputFile = new File(destFilePath);

        // connect to an OpenOffice.org instance running on port 8100
        OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
        connection.connect();

        // convert
        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
        converter.convert(inputFile, outputFile);

        // close the connection
        connection.disconnect();
    }       
}