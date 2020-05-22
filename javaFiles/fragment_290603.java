public class ThreadMultipleDateReceiver extends Thread {

    private static final int MAX_CLIENT_THREADS = 4;
    private byte[] incomingBytes;
    private volatile boolean isRunning;
    private volatile List<ThreadStreamDateWriter> lThrdDate;

    private PipedInputStream pipedInputStream;
    private PipedOutputStream pipedOutputStream;

    public ThreadMultipleDateReceiver() {
        lThrdDate = Collections.synchronizedList(new ArrayList<>(MAX_CLIENT_THREADS));
        pipedInputStream = new PipedInputStream();
        pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);
        System.out.println("ThreadMultipleDateReceiver Created");
    }

    @Override public void run() {
        isRunning = true;
        while (isRunning) {
            if (!lThrdDate.isEmpty()) {
                System.out.println("ThreadMultipleDateReceiver has:" + lThrdDate.size());
                for (int i = lThrdDate.size(); i > 0; i--) {
                    if (lThrdDate.get(i - 1).getState() == Thread.State.TERMINATED) {
                        lThrdDate.remove(i - 1);
                    } else {
                        System.out.println("ThreadMultipleDateReceiver have:" + lThrdDate.get(i - 1).getNameDateWriter());
                    }
                }
                incomingBytes = new byte[1024];
                try {
                    String str = "";
                    int iRd;
                    System.out.println("ThreadMultipleDateReceiver waiting:" + str);
                    while ((iRd = pipedInputStream.read(incomingBytes)) != -1) {
                        String r = new String(Arrays.copyOf(incomingBytes, iRd));
//                        if (iRd > 0) {
//                            str += r;
//                        }
                        System.out.println("ThreadMultipleDateReceiver Received:\t" + r);
                    }
//                    System.out.println("ThreadMultipleDateReceiver Received:\n\t:" + str);
                } catch (IOException e) { }
            } else {
                System.out.println("ThreadMultipleDateReceiver Empty");
            }
        }
        emptyDateWriters();
    }

public void addDateWriter(ThreadStreamDateWriter threadDateWriter) {
    if (lThrdDate.size() < MAX_CLIENT_THREADS) {
        lThrdDate.add(threadDateWriter);
    }
}

    private void emptyDateWriters() {
        if (!lThrdDate.isEmpty()) {
            for (int i = lThrdDate.size(); i > 0; i--) {
                ThreadStreamDateWriter threadDateWriter = lThrdDate.get(i - 1);
                threadDateWriter.stopThread();
                lThrdDate.remove(i - 1);
            }
        }
    }

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    public void stopThread() {
        isRunning = false;
    }

}