public static boolean isMusicOn() {
    return pref.getBoolean(MUSIC_ON);
}

public static void toggleMusic() {
    pref.putBoolean("music_on", !isMusicOn());
    pref.flush();
}