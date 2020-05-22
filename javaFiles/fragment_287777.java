oos = new ObjectOutputStream(s.getOutputStream());
    ois = new ObjectInputStream(s.getInputStream());

public void sendMessage(int message_id) throws IOException{
        oos.writeInt(message_id);
}