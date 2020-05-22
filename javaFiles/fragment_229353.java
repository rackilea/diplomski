public static void main(String [] args) {
    Client client = new Client("127.0.0.1");
    client.addMessageListener(new MessageListener() {
        public void messageRecieved(String message) {
            System.out.println(message);
        }
    });

    client.connect();
    System.out.println("Connected to server.");
    Scanner scanner = new Scanner(System.in);

    String userInput = null;
    boolean quit = false;
    do {
        userInput = scanner.readLine();
        if(userInput != null && userInput.equals("quit")) {
            client.sendMessage(userInput);
        } else {
            quit = true;
        }
    } while(!quit);
}