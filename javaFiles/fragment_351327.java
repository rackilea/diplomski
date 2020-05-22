public class Client {
    public static void main(String[] args) {

        Client client = new Client();
        boolean sucessful;

        do {
            String data = client.receiveData();
            successful = client.sendData(data);
        } while(successful);

        client.close();
    }

    public Client() {
        //setup connection and in/output streams
    }

    public String receiveData() {
        //read from input
    }

    public boolean sendData(String data) {
        //send data
    }

    public void close() {
    }
}