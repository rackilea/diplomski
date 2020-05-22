ProcessBuilder pb = new ProcessBuilder("/usr/bin/emacs");

Process proc = pb.start();     // start external program

proc.waitFor();                // wait for it to terminate

performAnotherTask();