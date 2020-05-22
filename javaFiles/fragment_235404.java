private void receive(){

         try{
            DatagramSocket socket = new DatagramSocket();

            byte[] buffer = new byte[2048];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);


            String msg = new String(buffer,0,packet.getLength());
            String[] coor = msg.split(" ");
            x = Integer.parseInt(coor[0]);
            y = Integer.parseInt(coor[1]);
            x1 = Integer.parseInt(coor[2]);
            y1 = Integer.parseInt(coor[3]);
            packet.setLength(buffer.length);
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
}