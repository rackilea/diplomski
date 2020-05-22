ProcessBuilder processBuilder = new ProcessBuilder(command);
JProgressBar progressBar = new JProgressBar();
progressBar.setIndeterminate(true);
Process p = processBuilder.start();

p.waitFor();
progressBar.setIndeterminate(false);
progressBar.setValue(progressBar.getMaxValue());