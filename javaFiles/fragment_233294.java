File file = new File("mario.txt");
try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String r = null;
    long fileLength = file.length();
    long readLength = 0;
    while ((r = br.readLine()) != null) {
        readLength += r.length();
        setProgress((int) (((float) readLength / (float) fileLength) * 100f);
    }
}