Process p = Runtime.getRuntime().exec(command);
Thread threadError = new Thread(new SyncPipe(p.getErrorStream(), b));
Thread threadInput = new Thread(new SyncPipe(p.getInputStream(), b));

threadError.start();
threadInput.start();

/* writing to process */

// wait until your process finished
p.waitFor();

// wait for both threads until they finished writing to files
threadError.join();
threadInput.join();

// read your files