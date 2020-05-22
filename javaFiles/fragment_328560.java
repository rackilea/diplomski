DataOutputStream output = new DataOutputStream(connection.getOutputStream());

private void sendMessage(String message) {
    displayMessage(message);

    try {
        output.writeUTF(message);
        output.flush();
    } catch (IOException e) {
        System.out.println("IO ex at sendMessage client");
    }

}