try {
    String params[] = new String[]{
        "C:\\Windows\\System32\\javaw.exe",
        "-cp",
        "C:\\...\\TestSimpleProcessBuilder\\build\\classes",
        "-Dsun.java2d.noddraw=true",
        "-Dswing.boldMetal=false",
        "-Dsun.locale.formatasdefault=true",
        "-Xmx768M",
        "-XX:MaxPermSize=128M",
        "testsimpleprocessbuilder/HelloWorld",
        "Boo"
    };
    ProcessBuilder pb = new ProcessBuilder(params);
    pb.redirectErrorStream();
    Process p = pb.start();
    InputStream is = p.getInputStream();
    int in = -1;
    while ((in = is.read()) != -1) {
        System.out.print((char) in);
    }
    is = p.getErrorStream();
    in = -1;
    while ((in = is.read()) != -1) {
        System.out.print((char) in);
    }
    System.out.println("p exited with " + p.exitValue());
} catch (IOException ex) {
    Logger.getLogger(TestSimpleProcessBuilder.class.getName()).log(Level.SEVERE, null, ex);
}