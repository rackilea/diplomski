public class ProcessTest {
private Process p;
private BufferedReader reader;
private BufferedWriter writer;

public void start() throws IOException {
    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
    pb.directory(new File("./"));
    this.p = pb.start();
    this.reader = new BufferedReader(new InputStreamReader(this.p.getInputStream()));
    this.writer = new BufferedWriter(new OutputStreamWriter(this.p.getOutputStream()));
    new Read(this.reader).start();
}

public boolean writeToConsole(String s) throws IOException {
    if (p == null)
        return false;
    this.writer.write(s + "\n");
    this.writer.flush();
    return true;
}

public class Read extends Thread {
    private BufferedReader reader;

    public Read(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() {
        try {
            String line;
            while ((line = this.reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public static void main(String[] args) {
    try {
        new ProcessTest().start();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}