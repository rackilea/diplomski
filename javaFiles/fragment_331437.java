for (i = 1; i < 33; i++) {
    if (Settings.totalHits >= 50 * i && !Settings.medal[i-1]) {
        Settings.medal[i-1] = true;
        Settings.save(game.getFileIO());
        totalMedals++;
    }
}