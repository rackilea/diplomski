import org.bouncycastle.crypto.tls.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;

public class FetchWorkaround {

    private static final String HOST = "repository.jboss.org";
    private static final int PORT = 443;
    private static final String RESOURCE = "/nexus/content/groups/public/javax/media/jai-core/1.1.3/jai-core-1.1.3.pom";

    public static void main(String[] args) throws Exception {
        TlsClientProtocol protocol = getTlsClientProtocol();
        sendRequest(protocol);
        readResponseStream(protocol.getInputStream());
    }

    private static void readResponseStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (TlsNoCloseNotifyException exception) {
            // do nothing
        }
    }

    private static void sendRequest(TlsClientProtocol protocol) throws IOException {
        OutputStream output = protocol.getOutputStream();
        output.write(("GET " + RESOURCE + " HTTP/1.1\r\n").getBytes("UTF-8"));
        output.write(("Host: " + HOST + "\r\n").getBytes("UTF-8"));
        output.write("Connection: close\r\n".getBytes("UTF-8")); // To force socket close immediately.
        output.write("\r\n".getBytes("UTF-8")); // HTTP 1.1 requirement: last line must be empty line.
        output.flush();
    }

    private static TlsClientProtocol getTlsClientProtocol() throws IOException {
        SecureRandom secureRandom = new SecureRandom();
        Socket socket = new Socket(InetAddress.getByName(HOST), PORT);
        TlsClientProtocol protocol = new TlsClientProtocol(socket.getInputStream(), socket.getOutputStream(), secureRandom);
        DefaultTlsClient client = new DefaultTlsClient() {
            public TlsAuthentication getAuthentication() throws IOException {
                TlsAuthentication auth = new TlsAuthentication() {
                    public void notifyServerCertificate(Certificate serverCertificate) throws IOException {
                    }

                    public TlsCredentials getClientCredentials(CertificateRequest certificateRequest) throws IOException {
                        return null;
                    }
                };
                return auth;
            }
        };
        protocol.connect(client);
        return protocol;
    }

}