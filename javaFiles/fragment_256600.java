import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Permission;


public class ExitChecker {

    public ExitChecker() {

        System.setSecurityManager(new ExitMonitorSecurityManager());

        Runtime.getRuntime().addShutdownHook(new Thread(new MyShutdownHook()));

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!line.equalsIgnoreCase("Q")) {
            try {
                System.out.println("Press a number to exit with that status.");
                System.out.println("Press 'R' to generate a RuntimeException.");
                System.out.println("Press 'O' to generate an OutOfMemoryError.");
                System.out.println("Press 'Q' to exit normally.");
                line = input.readLine().trim();

                processInput(line);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    private void processInput(String line) {
        if (line.equalsIgnoreCase("Q")) {
            // continue, will exit loop and exit normally
        } else if (line.equalsIgnoreCase("R")) {
            throwRuntimeException();
        } else if (line.equals("O")) {
            throwError();
        } else {
            // try to parse to number
            try {
                int status = Integer.parseInt(line);
                callExit(status);
            } catch(NumberFormatException x) {
                // not a number.. repeat question...
                System.out.println("\nUnrecognized input...\n\n");
            }
        }
    }

    public void callExit(int status) {
        System.exit(status);
    }

    public void throwError() {
        throw new OutOfMemoryError("OutOfMemoryError");
    }

    public void throwRuntimeException() {
        throw new RuntimeException("Runtime Exception");
    }

    public static void main(String[] args) {
        new ExitChecker();
    }

    private static class ExitMonitorSecurityManager extends SecurityManager {

        @Override
        public void checkPermission(Permission perm) {
            //System.out.println(perm.getName());
            //System.out.println(perm.getActions());
        }

        @Override
        public void checkPermission(Permission perm, Object context) {
            //System.out.println(perm.getName());
            //System.out.println(perm.getActions());
        }

        @Override
        public void checkExit(int status) {
            System.out.println("Setting exit value via security manager...");
            MyShutdownHook.EXIT_STATUS = status;
        }
    }

    private static class MyShutdownHook implements Runnable {

        public static Integer EXIT_STATUS;

        public void run() {

            System.out.println("In MyShutdownHook - exit status is " + EXIT_STATUS);
        }
    }

}