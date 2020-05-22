clientnum++;
    serverInput = new DataInputStream(connectionSock.getInputStream());
    serverOutput = new DataOutputStream(connectionSock.getOutputStream());
    System.out.println("java client > Connection made, sending number.<A:" + a + ",B:" + b + ">");
    int serverA = serverInput.readInt();// read the server prodduct a number
    System.out.println("product A number from server > " + serverA);                                    

    int serverB = serverInput.readInt();// read the server product b
    System.out.println("product A number from server > " + serverB);