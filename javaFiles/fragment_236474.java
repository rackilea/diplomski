/**
 * Our Message definition.  A message is capable of writing itself to
 * a DataOutputStream.
 */
public interface Message {
  void writeTo(DataOutputStream daos) throws IOException;
}

/**
 * Handler definition.  The handler contains two threads: One for sending
 * and one for receiving messages.  It is initialised with an open socket.
 */    
public class MessageHandler {
  private final DataOutputStream daos;
  private final DataInputStream dais;
  private final Thread sender;
  private final Thread receiver;
  private final BlockingQueue<Message> outboundMessages = new LinkedBlockingQueue<Message>();

  public MessageHandler(Socket skt) throws IOException {
    this.daos = new DataOutputStream(skt.getOutputStream());
    this.dais = new DataInputStream(skt.getInputStream());

    // Create sender and receiver threads responsible for performing the I/O.
    this.sender = new Thread(new Runnable() {
      public void run() {
        while (!Thread.interrupted()) {
          Message msg = outboundMessages.take(); // Will block until a message is available.

          try {
            msg.writeTo(daos);
          } catch(IOException ex) {
            // TODO: Handle exception
          }
        }
      }
    }, String.format("SenderThread-%s", skt.getRemoteSocketAddress()));

    this.receiver = new Thread(new Runnable() {
      public void run() {
        // TODO: Read from DataInputStream and create inbound message.
      }
    }, String.format("ReceiverThread-%s", skt.getRemoteSocketAddress()));

    sender.start();
    receiver.start();
  }

  /**
   * Submits a message to the outbound queue, ready for sending.
   */
  public void sendOutboundMessage(Message msg) {
    outboundMessages.add(msg);
  }

  public void destroy() {
    // TODO: Interrupt and join with threads.  Close streams and socket.
  }
}