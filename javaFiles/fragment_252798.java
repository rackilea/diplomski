...
Thread t = new Thread(new FTPFileSender(pasvHost, pasvPort, fileToSend));
t.start();

// wait for t to finish
t.join();