public class MessageReceiver {
  public void work() {
    while (true) {
      Message m = receiveMessage();
      AbstractCommand command = commandFactory.createCommandForMessage(m);
      command.execute();
    }
  }
}