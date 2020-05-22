try {
    while (true) {
        ServerSocket socketOnWhichToListenForClients = new ServerSocket(9876);
    }
} catch (Exception e) {
    System.out.println(e + "in server run class");
}