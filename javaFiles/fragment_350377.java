public void encryptData(int key) {
    System.out.println("Encrypt");
    try {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream("raw-text.data"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("temp_encrypted.data"));
        int ch;
        while((ch = in.read()) != -1) {
            // NOTE: write(int) method casts int to byte
            out.write(ch + key);
        }
        out.close();
        in.close();

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}

public void decryptData(int key) {
    System.out.println("Decrypt");
    try {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("temp_encrypted.data"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("decrypted.data"));
        int ch;
        while((ch = in.read()) != -1) {
                out.write(ch - key);
        }
        out.close();
        in.close();

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}