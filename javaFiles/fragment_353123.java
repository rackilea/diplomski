public static void main(String[] args){
    MyInputStream stream = new MyInputStream(new ByteArrayInputStream(new byte[] {0, 0, 1}));
    byte[] storage = new byte[3];
    try {
        stream.read(storage);
        for (int i = 0; i < storage.length; ++i){
            System.out.println(storage[i]); //0 0 1
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
    stream.close()

}