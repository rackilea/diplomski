Process p = null;
try {
    p = Runtime.getRuntime().exec("ls -l");
    //process output here
    p.waitFor();
} finally {
    if (p != null) {
        p.getOutputStream().close();
        p.getInputStream().close();
        p.getErrorStream().close(); 
    }
}