// Assume you already have a processBuilder all configured and ready to go
final Process process = processBuilder.start();
new Thread(new Runnable() {public void run() {
  IOUtils.copy(process.getOutputStream(), System.out);
} } ).start();
new Thread(new Runnable() {public void run() {
  IOUtils.copy(process.getErrorStream(), System.err);
} } ).start();
new Thread(new Runnable() {public void run() {
  IOUtils.copy(System.in, process.getInputStream());
} } ).start();