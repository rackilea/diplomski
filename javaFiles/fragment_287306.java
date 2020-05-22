Process process = new ProcessBuilder(args).start();

// Read standard output
new StreamConsumer(process.getInputStream()).start();

// You should also always read stderr
new StreamConsumer(process.getErrorStream()).start();

// Wait for process to end and check for cancel

while (!process.waitFor(100, TimeUnit.MILLISECONDS) {
  if (monitor.isCanceled() {
    // user canceled the job, destroy the process to return
    process.destroy();
    break;
  }
}