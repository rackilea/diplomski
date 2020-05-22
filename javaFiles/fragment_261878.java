public abstract class Message {

    public abstract void callHandler(Utility utility);

}

public class Message1 extends Message{

    public void callHandler(Utility utility) {
        utility.handler(this);
    }
}