private void readFileFromSDCard() {
    File directory = Environment.getExternalStorageDirectory();
    // Assumes that a file article.rss is available on the SD card
    File file = new File(directory + "/article.rss");
    if (!file.exists()) {
        throw new RuntimeException("File not found");
    }
    Log.e("Testing", "Starting to read");
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}