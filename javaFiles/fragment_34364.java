public class StackOverflow_10037379_jdk6 {

    private static Logger sLogger = Logger.getLogger(StackOverflow_10037379_jdk6.class.getName());

    // Shamelessy taken from Google and modified. 
    // I don't know who the original Author is.
    public static class StreamGobbler extends Thread {

        InputStream is;
        Logger logger;
        Level level;

        StreamGobbler(String logName, Level level, InputStream is) {
            this.is = is;
            this.logger = Logger.getLogger(logName);
            this.level = level;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    logger.log(level, line);
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Failed to read from Process.", ex);
            }
            logger.log(
                    Level.INFO, 
                    String.format("Exiting Gobbler for %s.", logger.getName()));
        }
    }

    public static class CLIPoolableObjectFactory extends BasePoolableObjectFactory<Process> {

        private String mProcessToRun;

        public CLIPoolableObjectFactory(String processToRun) {
            mProcessToRun = processToRun;
        }

        @Override
        public Process makeObject() throws Exception {
            ProcessBuilder builder = new ProcessBuilder();
            builder.redirectErrorStream(true);
            builder.command(mProcessToRun);
            Process process = builder.start();
            StreamGobbler loggingGobbler =
                    new StreamGobbler(
                    String.format("process.%s", process.hashCode()),
                    Level.INFO,
                    process.getInputStream());
            loggingGobbler.start();
            return process;
        }

        @Override
        public boolean validateObject(Process process) {
            try {
                process.exitValue();
                return false;
            } catch (IllegalThreadStateException ex) {
                return true;
            }
        }

        @Override
        public void destroyObject(Process process) throws Exception {
            // If PHP has a way to stop it, do that instead of destroy
            process.destroy();
        }

        @Override
        public void passivateObject(Process process) throws Exception {
            // Should really try to read from the InputStream of the Process
            // to prevent lock-ups if Rediret.INHERIT is not used.
        }
    }

    public static class CLIWorkItem implements Runnable {

        private ObjectPool<Process> mPool;
        private String mWork;

        public CLIWorkItem(ObjectPool<Process> pool, String work) {
            mPool = pool;
            mWork = work;
        }

        @Override
        public void run() {
            Process workProcess = null;
            try {
                workProcess = mPool.borrowObject();
                OutputStream os = workProcess.getOutputStream();
                os.write(mWork.getBytes(Charset.forName("UTF-8")));
                os.flush();
                // Because of the INHERIT rule with the output stream
                // the console stream overwrites itself. REMOVE THIS in production.
                Thread.sleep(100);
            } catch (Exception ex) {
                sLogger.log(Level.SEVERE, null, ex);
            } finally {
                if (workProcess != null) {
                    try {
                        // Seriously.. so many exceptions.
                        mPool.returnObject(workProcess);
                    } catch (Exception ex) {
                        sLogger.log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        // Change the 5 to 20 in your case. 
        ObjectPool<Process> pool =
                new GenericObjectPool<Process>(
                new CLIPoolableObjectFactory("mock_php.exe"), 5);

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100, true);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 1, TimeUnit.HOURS, queue);

        // print some stuff out.
        executor.execute(new CLIWorkItem(pool, "Message 1\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 2\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 3\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 4\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 5\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 6\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 7\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 8\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 9\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 10\r\n"));
        executor.execute(new CLIWorkItem(pool, "Message 11\r\n"));

        executor.shutdown();
        executor.awaitTermination(4000, TimeUnit.HOURS);

        pool.close();
    }
}