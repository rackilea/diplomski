do {
    System.out.println("waiting response");
    try {
        Response risp = (Response) in.readObject();
        risp.accept(resHandler);
    }
    catch (SocketException e) {
        // unhandled yet
    }
    Thread.sleep(500);
} while (waitForMessage);