public void run() {
    DataInputStream dis;
    try {
        dis = new DataInputStream(s.getInputStream());
        String message=dis.readUTF();
        System.out.println(message);

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }



}