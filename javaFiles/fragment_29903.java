public static void saveNumGames() {
    Log.d("saveNumGames", "Called");
    int numGames;
    File numGamesFile = new File(mainActivity.getFilesDir(), "numGames");
    try {
        numGames = new Integer(new String(Files.readAllBytes(Paths.get(mainActivity.getFilesDir() + "numGames"))));
    } catch (Exception e) {
        e.printStackTrace();
        numGames = 0;
    }

    try (FileOutputStream fos = new FileOutputStream(numGamesFile)) {
        numGames++;
        Log.d("numGames", Integer.toString(numGames));
        PrintWriter PW = new PrintWriter(fos);
        PW.write(String.valueOf(numGames));
        PW.flush();
        PW.close();
        if (numGames == 12) {
            Games.Achievements.unlock(MainActivity.apiClient, "CgkIlcXhyp4YEAIQDA");
        } else if (numGames == 50) {
            Games.Achievements.unlock(MainActivity.apiClient, "CgkIlcXhyp4YEAIQDQ");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}