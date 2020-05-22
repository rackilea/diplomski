public class MessageTypeA extends Message {

    @Override
    public void action() {
         if (webConnection.completed()) {
             // do the action
         } else {
             MessageQueue q = // find out what queue to put myself on
             q.queue(this);   // ********* HERE *********
         }
    }
}