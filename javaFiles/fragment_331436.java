if (Settings.totalHits >= 50 && !Settings.medal1) {
    Settings.medal1 = true;
    Settings.save(game.getFileIO());
    totalMedals++;
}

if (Settings.totalHits >= 100 && !Settings.medal2) {
    Settings.medal2 = true;
    Settings.save(game.getFileIO());
    totalMedals++;
}

// and so on.