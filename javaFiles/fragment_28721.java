import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTPClient;

/**
 * This class enables the ability to connect and trasfer data to the FTP server
 */

public class FtpUpDown {

    static Locale locale = new Locale("de"); // Locale is set to "de" for
                                                // Germany
    static ResourceBundle r = ResourceBundle.getBundle("Strings", locale); // ResourceBundle
                                                                            // for
                                                                            // different
                                                                            // languages
                                                                            // and
                                                                            // String
                                                                            // Management

    // FTP-Connection properties
    static String host = "IP-Address"; // IP-address
    static String username = "username"; // Username
    static int port = 21; // Port
    static String password = "password"; // Password

    /**
     * <h3>FTP-connection tester</h3>
     * 
     */

    public static boolean connect() {

        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(host, port);
            ftpClient.login(username, password);
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (Exception e) {
            // e.printStackTrace();
            System.err.println("Unable to connect"); // TODO String einfügen
            return (false);
        }
        System.out.println("Connection established"); // TODO String einfügen
        return (true);
    }

    /**
     * <h3>FTP-Status</h3>
     * 
     * @return
     * @throws IOException
     */
    static public String getStatus() {
        if (connect()) {
            return (r.getString("successConnectFTP"));
        } else {
            return (r.getString("unableToConnectFTP"));
        }
    }

    /**
     * <h3>FTP-filelist</h3>
     * 
     * @return String-Array der Dateinamen auf dem FTP-Server
     */

    public static String[] list() throws IOException {
        FTPClient ftpClient = new FTPClient();
        String[] filenameList;

        try {
            ftpClient.connect(host, port);
            ftpClient.login(username, password);
            filenameList = ftpClient.listNames();
            ftpClient.logout();
        } finally {
            ftpClient.disconnect();
        }

        return filenameList;
    }

    /**
     * <h3>FTP-Client-Download:</h3>
     * 
     * @return true falls ok
     */

    public static boolean download(String localResultFile,
            String remoteSourceFile, boolean showMessages) throws IOException {
        FTPClient ftpClient = new FTPClient();
        FileOutputStream fos = null;
        boolean resultOk = true;

        try {
            ftpClient.connect(host, port);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }
            resultOk &= ftpClient.login(username, password);
            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }
            fos = new FileOutputStream(localResultFile);
            resultOk &= ftpClient.retrieveFile(remoteSourceFile, fos);
            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }
            resultOk &= ftpClient.logout();
            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {/* nothing to do */
            }
            ftpClient.disconnect();
        }

        return resultOk;
    }


    /**
     * <h3>FTP-Client-Upload:</h3>
     * 
     * @param localSourceFile
     *            The source of local file
     * @param remoteResultFile
     *            Set the destination of the file
     * @param showMessages
     *            If set on TRUE messages will be displayed on the console
     * @return true Returns If successfully transfered it will return TRUE, else
     *         FALSE
     */
    public static boolean upload(String localSourceFile,
            String remoteResultFile, boolean showMessages) throws IOException {

        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        boolean resultOk = true;

        try {
            ftpClient.connect(host, port);

            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }
            resultOk &= ftpClient.login(username, password);
            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }

            fis = new FileInputStream(localSourceFile);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

            resultOk &= ftpClient.storeFile(remoteResultFile, fis);
            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }
            resultOk &= ftpClient.logout();
            if (showMessages) {
                System.out.println(ftpClient.getReplyString());
            }
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                ftpClient.disconnect();
            } catch (IOException e) {/* nothing to do */
            }
        }

        return resultOk;
    }   


    // Setter and Getter-methods
    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        FtpUpDown.host = host;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        FtpUpDown.username = username;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        FtpUpDown.port = port;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        FtpUpDown.password = password;
    }
}