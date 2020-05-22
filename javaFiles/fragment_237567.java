public void convert(){
    try {
        byte[] cp1252 = new byte[]{(byte) 0xB5};
        byte[] utf8= new String(cp1252, "Cp1252").getBytes("UTF-8");
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
}