public class PBTest {

static List<Runnable> list = new ArrayList<Runnable>();

public static void main(String args[]) {
    ProcessBuilder pb1 = new ProcessBuilder("foo.exe");
    ProcessBuilder pb2 = new ProcessBuilder("foo.exe");
    ProcessBuilder pb3 = new ProcessBuilder("foo.exe");
    addPB(pb1);
    addPB(pb2);
    addPB(pb3);

    ExecutorService ex = Executors.newFixedThreadPool(1);
    for (Runnable r : list) {
        System.out.println("calling execute");
        ex.execute(r);
    }

    ex.shutdown();
}

static void addPB(final ProcessBuilder pb) {
    list.add(new Runnable() {
        public void run() {
            try {
                pb.start();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    });
}