public static void main(String[] args) {
    File file = new File("song.mp3");

    FileInputStream fIn = null;
    try {
        fIn = new FileInputStream(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    int chunk_size = 1024 * 100;
    byte[] buff = new byte[chunk_size]; // 100KB file
    int i = 0;
    String file_name = file.getName();
    String file_name_base = file_name.substring(0, file_name.lastIndexOf("."));
    int bytesReadCounter;
    boolean hasMore = true;
    while (hasMore) {
        try {
            bytesReadCounter = fIn.read(buff, 0, chunk_size);
        } catch (IOException e) {
            e.printStackTrace();
            break;
        }

        hasMore = bytesReadCounter > 0;

        if (!hasMore)
            break;

        String file_name_new = file_name_base + "_" + i + ".mp3";
        File file_new = new File(file_name_new);

        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(file_new);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            break;
        }

        try {
            fOut.write(buff, 0, bytesReadCounter);
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            break;
        }

        i++;
    }

    try {
        fIn.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}