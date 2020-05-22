DatagramPacket request = new DatagramPacket(buffer, buffer.length);
    aSocket.receive(request);
    String message = new String(request.getData()).trim();
    System.out.println("Received: " + new String(request.getData()));
    System.out.println(message); //Prints out "11" without quotes when I send it
    String a = "11";
    System.out.println("Received: " + message);
    if(message.equals("11")){
        System.out.println("Got 11.");
    }