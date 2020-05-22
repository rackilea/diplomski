public class ThreadStreamDateWriter extends Thread {
    String Self;
    private byte[] outgoingBytes;
    private volatile boolean isRunning;
    private final PipedOutputStream pipedOutputStream;


    ThreadStreamDateWriter(String name, PipedOutputStream src) {
        Self = name;
        pipedOutputStream = src;
    }

    @Override public void run() {
        isRunning = true;
        while (isRunning) {
            try {
                outgoingBytes = getInfo().getBytes();
                System.out.println("ThreadStreamDateWriter -> write to pipedOutputStream:" + new String(outgoingBytes));
                pipedOutputStream.write(outgoingBytes);
                System.out.println("ThreadStreamDateWriter -> wrote:" + new String(outgoingBytes));
                try { Thread.sleep(4000); } catch (InterruptedException ex) { }
            } catch (IOException | NegativeArraySizeException | IndexOutOfBoundsException e) {
                isRunning = false;
            }
        }
    }

    String getInfo() {
      String sDtTm = new SimpleDateFormat("yyyyMMdd-hhmmss").format(Calendar.getInstance().getTime());
      return Self + " -> " + sDtTm;
    }

    public void stopThread() {
        isRunning = false;
    }

    public String getNameDateWriter() {
        return Self;
    }
}