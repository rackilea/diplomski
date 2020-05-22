public void convertFiles() {
    File imgFile;
    byte[] bytes;
    FileOutputStream fos;
    String temp;

    for (int i = 0; i < files.size(); i++) {
        temp = "";

        try {
            // 'read' method can be found below
            bytes = read(files.get(i));

            // read the 8 byte string from the beginning of the file
            for(int j = 0; j < 8; j++) {
                temp += (char) bytes[j];
            }

            imgFile = new File("img.jpg");

            // points to './img.jpg'
            fos = new FileOutputStream(imgFile);

            // write from offset 8 to end of 'bytes'
            fos.write(bytes, 8, bytes.length - 8);

            fos.close();
        } catch (FileNotFoundException e) {
            // Logger stuff
        } catch (IOException ex) {
            // Logger stuff
        }

        System.out.println("[temp]:> " + temp);
    }

}