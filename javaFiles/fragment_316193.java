public void mReadJsonData() {
    try {
        File f = new File("sdcard/text/testfile.txt");
        FileInputStream is = new FileInputStream(f);
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        String text = new String(buffer);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}