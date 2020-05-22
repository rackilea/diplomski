private void loadScores()
{
    File file = new File(saveDataPath, filename);

    BufferedReader reader = null;
    //        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
    try {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));            
        String line = reader.readLine();

        wins = Integer.parseInt(line);

        line = reader.readLine();
        losses = Integer.parseInt(line);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    finally {
        if (reader != null) {
            try {
                reader.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}