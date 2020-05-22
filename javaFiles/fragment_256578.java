// Sender
    List list = new ArrayList();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    ObjectOutputStream outputStream = new ObjectOutputStream(out);
    outputStream.writeObject(list);
    outputStream.close();

    byte[] listData = out.toByteArray();


    // Reciever
    ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(listData));
    list = inputStream.readObject();