try {
    File localFile  = new File(Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOWNLOADS), "New_Audio.mp3");
    localFile .createNewFile();
    down.getFile(localFile);
} catch (IOException e) {
    e.printStackTrace();
}