public class ClientHandler {
    ...
    private static volatile UserProcess userProcess;
    ...
    // client handler
    if (userProcess != null) {
        // return error that the perl process is already started
    } else {
        // start the process
        Process process = Runtime.getRuntime.exec('perl script.pl');
        userProcess = new UserProcess(userId, process);
    }