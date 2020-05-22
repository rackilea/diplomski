public class Test {

    static class StreamReader extends Thread {
        InputStream stream;
        StreamReader(InputStream stream) {
            this.stream = stream;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(stream);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("mvn -version");
            new StreamReader(proc.getInputStream()).start();
            new StreamReader(proc.getErrorStream()).start();
            int exitVal = proc.waitFor();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}