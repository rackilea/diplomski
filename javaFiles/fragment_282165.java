public class ReceivedMessage {
    String text;
    String created;
}

public static void main(String[] args) {
    String result = "[{\"text\": \"lala\", \"created\": \"123456\"}, "
                    +"{\"text\": \"lele\", \"created\": \"123456\"}]";

    List<ReceivedMessage> receivedMessages = new Gson().fromJson(result,
                      new TypeToken<List<ReceivedMessage>>() {}.getType());

    for (ReceivedMessage mess : receivedMessages) {
        System.out.println("This is it " + mess.created);
    }

    ....
}