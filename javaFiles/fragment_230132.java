WatCardData myData = new WatCardData();
    try {
        FileOutputStream fos = new FileOutputStream("lastBalance");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(myData);
        os.close();
        fos.close();
    } catch(Exception e) {
        e.printStackTrace();
    }