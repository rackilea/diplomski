ProcessBuilder processBuilder = new ProcessBuilder(command);
JProgressBar progressBar = new JProgressBar();

processBuilder.redirectErrorStream(true);
Process p = processBuilder.start();
InputStream is = p.getInputStream();
try {
    in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    while ((line = in.readLine()) != null) {
        //error checking
       int progressValue = Integer.parseInt(line);
      progressBar.setValue(progressValue);
    } finally {
       in.close();
    }
}
progressBar.setValue(progressBar.getMaxValue());