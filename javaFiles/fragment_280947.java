ProcessBuilder pb = new ProcessBuilder(args);
Process proc_1 = pb.start();
Process proc_2 = pb.start();

boolean running = true;
while (running) {
    try {
        int exitValue = proc_1.exitValue();
        System.out.println("Child_1 finished with exit value -> " + exitValue);
        if(exitValue==0) {
            proc_2.destroy();
            running = false;
            break;
        }
    } catch (IllegalThreadStateException exp) {
    }
    try {
        int exitValue = proc_2.exitValue();
        System.out.println("Child_2 finished with exit value -> " + exitValue);
        if(exitValue==0) { 
            proc_1.destroy();
            running = false; 
            break;
        }
    } catch (IllegalThreadStateException exp) {
    }
}