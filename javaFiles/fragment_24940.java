private void startGradleExecutorService() {
    statusLabel.setText("Building...");
    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(() -> {

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", projectPath + "/gradlew assembleRelease -p" + projectPath, "--info");
        builder.redirectErrorStream(true);
        try {
            Process p = builder.start();
            BufferedReader stdout = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            System.out.println("outputString:: " + stdout.readLine());

            while ((outputString = stdout.readLine()) != null) {
                System.out.println("outputString:: " + outputString);
                Platform.runLater(() -> {
                    //if you change the UI, do it here !

                    statusLabel.setText(outputString);

                });
                if (outputString.contains("BUILD")) {
                    break;
                }
            }
            p.getInputStream().close();
            p.getOutputStream().close();
            p.getErrorStream().close();
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
}