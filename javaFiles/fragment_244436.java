try
     {
         lSocket = new Socket("localhost", 7651);
         lDataStream = new DataInputStream(lSocket.getInputStream());

     }
     catch (UnknownHostException e)
     {
         System.out.println("Unknown host: localhost");
         System.exit(1);
     }
     catch  (IOException e)
     {
         System.out.println("No I/O");
         System.exit(1);
     }

     //Receive data from ROS SerialtoNetwork server

     try 
     {
         while(true)
         {
            //in.readInt();
            byte[] cbuf = new byte[257];
            lDataStream.readFully(cbuf);        

            String lstr = new String(cbuf);
            System.out.print(lstr);

            System.out.println("");
         }            
    } 
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }