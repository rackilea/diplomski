public String ls () {
    Class<?> execClass = Class.forName("android.os.Exec");
    Method createSubprocess = execClass.getMethod("createSubprocess", String.class, String.class, String.class, int[].class);
    int[] pid = new int[1];
    FileDescriptor fd = (FileDescriptor)createSubprocess.invoke(null, "/system/bin/ls", "/", null, pid);

    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fd)));
    String output = "";
    try {
        String line;
        while ((line = reader.readLine()) != null) {
            output += line + "\n";
        }
    }
    catch (IOException e) {}
    return output;
}