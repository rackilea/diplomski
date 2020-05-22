public class Foo {
  // instead of LinkedList<DatagramPacket>
  public LinkedList<String> queue = new LinkedList<String>(); 
  public void addPacket(DatagramPacket additional) {
      queue.add(new String(additional.getData()));
    }
  }
}