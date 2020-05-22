class SocketClientThread implements Runnable {
        DataInputStream dis;
        DataOutputStream dos;
        String strResponseData;

        @Override
        public void run() {
            try {
                InetAddress serverAddr = InetAddress.getByName("<address>");
                clientSocket = new Socket(serverAddr, <port_number - 80 in your example>);
                dos = new DataOutputStream(clientSocket.getOutputStream());
                dis = new DataInputStream(clientSocket.getInputStream());

                // now you can write data to stream
                dos.writeUTF("Hello");

                // you can also read data from stream
                strResponseData = dis.readUTF();


            } catch (UnknownHostException ignore) {
            } catch (IOException ignore) {
            }

            finally{
                if (clientSocket != null){
                    try {
                        clientSocket.close();
                    } 
                    catch (IOException ignore) {
                    }
                }
            }
        }
}