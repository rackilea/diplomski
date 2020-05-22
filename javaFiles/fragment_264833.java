public static void main(String[] args) {

    Server serve = new Server();
    Thread serverSender = new Thread(new ServerSender(serve.printWriter));
    Thread serverReceiver = new Thread(new ServerReceiver(serve.bufferedReader));
    serverSender.start();
    serverReceiver.start();
}