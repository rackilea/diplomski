class Message{
    private short length;
    private String text;
    private String whatever;

    @Override
    public String toString() {
        return "Message [length=" + length + ", text=" + text + ", whatever=" + whatever
                + "]";
    }       
}

public class Demo {    
    public static void main(String[] args) {
        String request = "{'length':10, 'text':'foo bar'}";
        Gson gson = new Gson();
        Message msg = gson.fromJson(request, Message.class);
        System.out.println(msg);
    }
}