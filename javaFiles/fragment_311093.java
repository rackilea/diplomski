public class FileSaver extends Thread {

    Socket socket;

    public FileSaver(Socket socket) {
        socket = socket;
    }

    public saveFile() {
        // save the file here
    };

    public void run() {
        saveFile();
    }

}