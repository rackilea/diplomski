int maxNumberOfThreads = ...; // your choice
int bufSize = ...; // your choice

ExecutorService exec = Executors.newFixedThreadPool(maxNumberOfThreads);
DatagramSocket serverSocket = new DatagramSocket(9876);

while (true) {
    // we need to create a new buffer every time because
    // multiple threads will be working with the data
    DatagramPacket receivePacket = 
        new DatagramPacket(new byte[bufSize], bufSize);
    serverSocket.receive(receivePacket);
    exec.submit(new YourTask(receivePacket));
}