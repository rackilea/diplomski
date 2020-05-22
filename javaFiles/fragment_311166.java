try {
    raf.seek(index);
    byte[] bytes = raf.readFully(new byte[(int) length]); //length of the charactersequence to be read
    String str = bytes.toString();
} catch (IOException e){
    e.printStackTrace();
}