public class TCPClient {
    // ...
    public static void main(String[] args) {
        try (Socket client = new Socket(hostname, PORT);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
             DataOutputStream out = new DataOutputStream(client.getOutputStream())) {
            // ...
            while (!(input = stdIn.readLine()).equalsIgnoreCase("end")) {
                // ...
                encode(message, out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encode(Message message, DataOutputStream out) throws IOException {
        out.writeUTF(message.getMessage());
        out.writeInt(message.getId());
    }
}