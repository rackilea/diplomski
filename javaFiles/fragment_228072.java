Socket socket = ... // Set up receive socket
DataInputStream dIn = new DataInputStream(socket.getInputStream());

boolean done = false;
while(!done) {
  byte messageType = dIn.readByte();

  switch(messageType)
  {
  case 1: // Type A
    System.out.println("Message A: " + dIn.readUTF());
    break;
  case 2: // Type B
    System.out.println("Message B: " + dIn.readUTF());
    break;
  case 3: // Type C
    System.out.println("Message C [1]: " + dIn.readUTF());
    System.out.println("Message C [2]: " + dIn.readUTF());
    break;
  default:
    done = true;
  }
}

dIn.close();