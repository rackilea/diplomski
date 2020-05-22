public class SendImageUDP {
  public static void main(String args[]) throws IOException {
    BufferedImage img = ImageIO.read(new File("your_pic.jpg"));
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(img, "jpg", baos);
    baos.flush();
    byte[] imageBuffer = baos.toByteArray();
    System.out.println(imageBuffer.length);

    InetAddress IPAddress = InetAddress.getByName("127.0.0.1"); // LocalHost for testing on the same computer
    DatagramSocket clientSocket = new DatagramSocket(9090, IPAddress); // Specify sending socket

    DatagramPacket packet = new DatagramPacket(imageBuffer, imageBuffer.length, IPAddress, 9091);
    clientSocket.send(packet);

    System.out.println("data sent");
    clientSocket.close();
  }
}