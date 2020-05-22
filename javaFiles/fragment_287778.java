private void makeCopy(Socket clientSock) throws IOException {
        File file = new File("D:\\klient\\doKopii.bmp");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[4096];

        while (fis.read(buffer) > 0) {
            oos.write(buffer);
        }
}