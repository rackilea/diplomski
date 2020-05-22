public class Controller {

    public static void main(String args[]) {


        //create UDP server
        try {
            DatagramSocket socket = new DatagramSocket(5002);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            //wait for done message
            socket.receive(packet);

            //Get actual data length and copy it
            byte[] data = new byte[packet.getLength()];
            System.arraycopy(packet.getData(), packet.getOffset(), data, 0, packet.getLength());

            //Create string from actual data
            String msg = new String (data);
            if(msg.equals("Done"))
            {
                System.out.println("Done received");
            }
            else {
                System.out.println("Done not received");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}