public static void main(String [] args) throws IOException {
    File file = new File("./resources/so.png");
    BufferedInputStream bufRead =  new BufferedInputStream(new FileInputStream(file));
    ByteBuffer buffer = ByteBuffer.allocate(30*1024) ; // x kb
    byte[] c = new byte[1];     
    while ((bufRead.read(c))>0) { //1 byte/time to avoid buffer arithmetics 
        buffer.put(c);
    }
    byte[] data = new byte[buffer.position()];
    buffer.flip();
    buffer.get(data);
    String dataAsSt = new String(data); // transform the data to a string -- encoding error-prone
    //gwt-base64
    //String gwtBase64 = GwtBase64.encode(dataAsSt);  //doesn't work

    //google base64 impl
    String googleBase64 = Base64Utils.toBase64(data);

    //apache base64 codec
    Base64 base64codec = new Base64(-1);
    String apacheBase64 = base64codec.encodeToString(data);

    System.out.println("Google:"+googleBase64);
    System.out.println("Apache:"+apacheBase64);
    //System.out.println("GWTb64:"+gwtBase64);
}