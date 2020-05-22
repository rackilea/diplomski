private static class FileLogger extends Thread {
    private File logFile;
    private PrintWriter logWriter;
    private final BlockingQueue<LogNode> logNodes = new LinkedBlockingQueue<>();

    public FileLogger(Context context) {
        String dateString = (String) DateFormat.format("yyyy-MM-dd_HH:mm:ss", new Date());
        File logsDir = new File(context.getCacheDir(), "logs");

        if (logsDir.exists()) {
            for (File file : logsDir.listFiles()) {
                file.delete();
            }
        }

        try {
            logFile = new File(logsDir, dateString + ".log");
            if (!logFile.exists()) {
                logFile.getParentFile().mkdirs();
                logFile.createNewFile();
            }

            logWriter = new PrintWriter(new FileOutputStream(logFile));
            start();
        } catch (IOException ignored) {
        }
    }

    public void log(Date date, String tag, String msg) {
        if (isAlive()) {
            logNodes.add(new LogNode(date, tag, msg));
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                LogNode node = logNodes.take();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
                logWriter.println(String.format(
                        "%s %s.%s", dateFormat.format(node.date), node.tag, node.msg
                ));
                logWriter.flush();
            } catch (InterruptedException e) {
                logWriter.flush();
                logWriter.close();
                return;
            }
        }
    }
}