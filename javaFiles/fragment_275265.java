String partialIp = "192.168.1.";
int port = 123;
int counter;
boolean found;
String ip;

Runnable tryNextIp = new Runnable() {
    @Override
    public void run() {
        int myIp = counter++;
        String targetIpTemp = partialIp + myIp;
        Socket socketTemp = new Socket();
        try {           
            socketTemp.connect(new InetSocketAddress(targetIpTemp, port), 6000);
            socketTemp.close();
            ip = targetIpTemp;
            found = true;
        } catch (IOException e) {               
            try {
                socketTemp.close();
            } catch (IOException e1) {}
        }
    }
};

String findIp() {
    counter = 0;
    found = false;

    ExecutorService executorService = Executors.newFixedThreadPool(256);
    for (int i=0; i<256; i++) {
        if (found)
            break;
        executorService.execute(tryNextIp);
    }           
    executorService.shutdown();
    try {
        while (!found && !executorService.isTerminated())
            executorService.awaitTermination(200, TimeUnit.MILLISECONDS);               
    } catch (InterruptedException e) {}
    if (found)
        return ip;
    else
        return null;
}