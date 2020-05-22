public class StackOverflow_10037379 {

    private static Logger sLogger = Logger.getLogger(StackOverflow_10037379.class.getName());

    public static class CLIPoolableObjectFactory extends BasePoolableObjectFactory<Process> {

        private String mProcessToRun;

        public CLIPoolableObjectFactory(String processToRun) {
            mProcessToRun = processToRun;
        }

        @Override
        public Process makeObject() throws Exception {
            ProcessBuilder builder = new ProcessBuilder();
            builder.redirectError(Redirect.INHERIT);
            // I am being lazy, but really the InputStream is where
            // you can get any output of the PHP Process. This setting
            // will make it output to the current processes console.
            builder.redirectOutput(Redirect.INHERIT);
            builder.redirectInput(Redirect.PIPE);
            builder.command(mProcessToRun);
            return builder.start();
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
        // Also change mock_php.exe to /usr/bin/php or wherever.
        ObjectPool<Process> pool =
                new GenericObjectPool<>(
                new CLIPoolableObjectFactory("mock_php.exe"), 5);         

        // This will only allow you to queue 100 work items at a time. I would suspect
        // that if you only want 20 PHP processes running at a time and this queue
        // filled up you'll need to implement some other strategy as you are doing
        // more work than PHP can keep up with. You'll need to block at some point
        // or throw work away.
        BlockingQueue<Runnable> queue = 
            new ArrayBlockingQueue<>(100, true);

        ThreadPoolExecutor executor = 
            new ThreadPoolExecutor(20, 20, 1, TimeUnit.HOURS, queue);

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