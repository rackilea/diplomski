@FXML
private void captureEvents() {

    Thread thread = new Thread(() -> {
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd \"C:\\Users\\a\\Desktop\\users\"&& user.exe");
        builder.redirectErrorStream(true);

        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line ;
            int lineNumber=1;
            while (true ) {

                line = r.readLine();

                if (line==null)
                    break;
                parseLine(line);

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    });
    thread.start();
}