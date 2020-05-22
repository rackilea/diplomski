import org.apache.james.mime4j.stream.*;
import static org.apache.james.mime4j.stream.MimeTokenStream.*;
import java.io.*;

public class Library {
    private static final String SEP = " -----Original Message-----";
    private static final String CRLF = "\r\n";

    static int fileNo = 0;

    public static void main(String[] args) throws Exception {
        MimeTokenStream stream = new MimeTokenStream();
        stream.parse(new FileInputStream(args[0]));
        try (BufferedWriter headerWriter = new BufferedWriter(new FileWriter("header"))) {
            for (EntityState state = stream.getState();
                    state != EntityState.T_END_OF_STREAM;
                    state = stream.next()) {
                switch (state) {
                case T_BODY:
                    writePart(new BufferedReader(new InputStreamReader(stream.getInputStream())));
                    break;
                case T_FIELD:
                    headerWriter.write(stream.getField().toString());
                    headerWriter.write(CRLF);
                    break;
                }
            }
        }
    }

    private static void writePart(BufferedReader in) throws Exception {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(fileNo + ".eml"));
            String line = in.readLine();
            while (line != null) {
                if (SEP.equals(line)) {
                    out.close();
                    fileNo++;
                    out = new BufferedWriter(new FileWriter(fileNo + ".eml"));
                }
                out.write(line);
                out.write(CRLF);
                line = in.readLine();
            }
        }
        finally {
            out.close();
        }
    }
}