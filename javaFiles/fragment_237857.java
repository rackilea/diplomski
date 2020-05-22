public class MyApp {

    static class StreamGobbler extends Thread {

        InputStream is;
        String type;

        StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(type + ">" + line);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        /*if (args.length < 1) {
            System.out.println("USAGE: java GoodWindowsExec <cmd>");
            System.exit(1);
        }*/
        args = new String[]{"echo \"test\" | grep -i \"s\" " };
        try {
            String[] cmd = new String[3];
            Runtime rt = Runtime.getRuntime();
            System.out.println("Execing " + args[0]);
            //Change here: execute a shell with the command line instead of echo:
            Process proc = rt.exec(new String[]{"/bin/sh","-c", args[0]});
            // any error message?
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");
            // any output?
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");
            // kick them off
            errorGobbler.start();
            outputGobbler.start();
            // any error???
            int exitVal = proc.waitFor();
            System.out.println("ExitValue: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}