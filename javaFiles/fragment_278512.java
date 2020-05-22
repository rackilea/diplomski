some self explanatory extra code:

//somewhere before:
//Global variables
    String defaultValue="0",ip="xxx.xx.xx.xx";
    DatagramSocket remoteSocket,localSocket;
    byte[] receiveArray,receiveKey,receiveSig,sendSig;
    int remoteSendPort=xxx,localSendport=xxx,
        remoteReceivePort=xxx,localReceivePort=xxx;    
    String feedback,control_val,ReceivedTimeStamp;
    InetAddress IPAddress;     
...
//receive message from the other java program in pc2 
    public  void remoteMsgSend(byte[] msg,InetAddress IPAddress, int PORT)  {     
        try {     
            DatagramPacket sendPacket = null;
            try {
                sendPacket = new DatagramPacket(msg, msg.length, IPAddress, PORT);
            } catch (Exception e) {
                System.out.printf("Error! check ports");
            }
            remoteSocket.send(sendPacket);
        } catch (IOException ex) {
            System.out.println("IOException! remote send");
        }
    }
    //receive message from the other java program in pc2
    public  String remoteMsgReceive() {                     
         DatagramPacket receivePacket = new DatagramPacket(receiveArray, receiveArray.length);
         byte[] r1;
         int count=0,len,offset;
           try {
               remoteSocket.receive(receivePacket);
               r1=receivePacket.getData();
               len=receivePacket.getLength();
               offset=receivePacket.getOffset();
               r1=Arrays.copyOfRange(r1, offset, len);
               remoteOk=true;
                return new String(r1);
                } catch (Exception ex) {
//                    System.out.println("remote receive time out: " +ex.getMessage());
                    remoteOk=false;
                    return defaultValue;
                }
     }

    //send data to matlab on this pc
    public  void localSend(String msg,int PORT)  {  
        DatagramPacket sendPacket = null;
        try {
            sendPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getLocalHost(), PORT);
        } catch (Exception e) {
            System.out.printf("Error! check ports");
        }
        try {
            localSocket.send(sendPacket);
        } catch (IOException ex) {
            System.out.println("localsend error");
        }
    }
    //receive data from Matlab on this pc
    public  String localReceive() {                     
         DatagramPacket receivePacket = new DatagramPacket(receiveArray, receiveArray.length);

         String rec;
           try {
               localSocket.receive(receivePacket);
               rec=new String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());
               localOk=true;
                return rec;
                } catch (Exception ex) {
//                          System.out.println("local receive time out " +ex.getMessage());
                          localOk=false;
                          return defaultValue;
                }
     }