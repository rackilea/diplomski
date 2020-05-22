socket = new DatagramSocket();
Thread readerWorker = new ReaderWorker(socket);
readerWorker.start();

Thread writerWorker = new WriterWorker(socket);
writerWorker.start();