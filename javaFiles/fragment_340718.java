public static String readDataFromSd() throws IOException {

    //Environment.getExternalStorageDirectory() is /storage/emulated/0
    File sdcard = Environment.getExternalStorageDirectory();
    String line = "";
    File file = new File(sdcard.getAbsolutePath() + File.separator + "response.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    Log.d(TAG, "File " + file);
    StringBuilder text = new StringBuilder();
    try {

        while ((line = br.readLine()) != null) {
            if (line.length() > 0) {
                text.append(line);
                text.append('\n');
            }
        }
        br.close();
        Log.e(TAG, "Data " + text.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
    return new String(text);
}