try {
    final Process process = Runtime.getRuntime().exec(
            new String[] { "your-program", "some-more-parameters" });
    if (process != null) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DataInputStream in = new DataInputStream(
                            process.getInputStream());
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(in));
                    String line;
                    while ((line = br.readLine()) != null) {
                        // handle input here ... ->
                        // if(line.equals("Enter Password:")) { ... }
                    }
                    in.close();
                } catch (Exception e) {
                    // handle exception here ...
                }
            }
        }).start();
    }
    process.waitFor();
    if (process.exitValue() == 0) {
        // process exited ...
    } else {
        // process failed ...
    }
} catch (Exception ex) {
    // handle exception
}