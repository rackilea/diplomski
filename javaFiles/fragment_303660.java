public class Boot {

    public static void main(String[] args) {
        String location = Boot.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        location = URLDecoder.decode(location, "UTF-8").replaceAll("\\\\", "/");
        String app = Application.class.getCanonicalName();
        String flags = "-Xbootclasspath/p:canvas.jar";
        boolean windows = System.getProperty("os.name").contains("Win");

        StringBuilder command = new StringBuilder(64);
        if (windows) {
            command.append("javaw");
        } else {
            command.append("java");
        }
        command.append(' ').append(flags).append(' ');
        command.append('"').append(location).append('"');
        // append any necessary external libraries here
        for (String arg : args) {
             command.append(' ').append('"').append(arg).append('"');
        }

        Process application = null;
        Runtime runtime = Runtime.getRuntime();
        if (windows) {
            application = runtime.exec(command.toString());
        } else {
            application = runtime.exec(new String[]{ "/bin/sh", "-c", command.toString() });
        }

        // wire command line output to Boot to output it correctly
        BufferedReader strerr = new BufferedReader(new InputStreamReader(application.getErrorStream()));
        BufferedReader strin = new BufferedReader(new InputStreamReader(application.getInputStream()));
        while (isRunning(application)) {
            String err = null;
            while ((err = strerr.readLine()) != null) {
                System.err.println(err);
            }
            String in = null;
            while ((in = strin.readLine()) != null) {
                System.out.println(in);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ignored) {
            }
        }
    }

    private static boolean isRunning(Process process) {
        try {
            process.exitValue();
        } catch (IllegalThreadStateException e) {
            return true;
        }
        return false;
    }
}