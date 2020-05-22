@Override
public void run() {
    // read and service request on socket
    BufferedReader in = null;
    try {
        in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

        while ((recievedPacket = in.readLine()) != null) {
            //recievedPacket = in.readLine();
            System.out.println("Recieved packate " + recievedPacket);

            if (recievedPacket != null) {
                try {
                    System.out.println("Saving function " + recievedPacket);


                } catch (Exception ex) {
                     System.out.println(ex);
                }

            }

        }

    } catch (IOException ex) {
       System.out.println(ex);
    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (IOException ex) {
                // No-OP
            }

        }

        if (socket != null) {
            try {
                scoket.close();
            } catch (IOException ex) {
                // No-OP
            }
        }
    }
}