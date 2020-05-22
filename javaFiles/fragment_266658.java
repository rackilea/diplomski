// Option 2
process.waitFor(5, TimeUnit.SECONDS);  // let the process run for 5 seconds
process.destroy();                     // tell the process to stop
process.waitFor(10, TimeUnit.SECONDS); // give it a chance to stop
process.destroyForcibly();             // tell the OS to kill the process
process.waitFor();                     // the process is now dead