try {
    ProcessBuilder builder = new ProcessBuilder("open.bat");
    builder.redirectError();
    builder.inheritIO();
    final Process process = builder.start();
    final InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String text = null;
    while ((text = br.readLine()) != null) {
        System.out.println(text);
    }

    System.out.println("command line terminated");
    System.out.println("Exited with " + process.waitFor());
} catch (Exception err) {
    err.printStackTrace();
    System.out.println("error  ");
}