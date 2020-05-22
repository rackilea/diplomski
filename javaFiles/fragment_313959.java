//        Process rt = Runtime.getRuntime().exec("python3 -m /Users/<user-name>/demo/JavaNotepad/src/main/java/com/mypython.py");
        ProcessBuilder builder = new ProcessBuilder("python3", "-m", "/Users/<user-name>/demo/JavaNotepad/src/main/java/com/mypython.py");
        Process rt = builder.start();
        int exitCode = rt.waitFor();
        System.out.println("Process exited with : " + exitCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(rt.getInputStream()));
        BufferedReader err = new BufferedReader(new InputStreamReader(rt.getErrorStream()));

    System.out.println("Python file output:");
    String line;
    BufferedReader reader;
    if (exitCode != 0) {
        reader = err;
    } else {
        reader = in;
    }
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }