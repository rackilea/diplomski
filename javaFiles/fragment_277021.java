DataInputStream clientInput = new DataInputStream( connectionSock.getInputStream( ));
   DataOutputStream clientOutput = new DataOutputStream( connectionSock.getOutputStream( ));
   System.out.println("java Server > Connection made, waiting for client " + "to send their ptoduct number.");
   System.out.println("test");

   clientOutput.writeInt(producta); //writeInt() not write()
   clientOutput.writeInt(productb);