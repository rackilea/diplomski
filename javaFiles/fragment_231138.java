static
{
    screenThemes = new HashMap<Screen, Music>();
    currentlyPlayed = null;
}

public static boolean getSoundEnabled()
{
    return MyGame.getPreferences().getBoolean(Resources.soundEnabledKey);
}

private static Map<Screen, Music> screenThemes;

public static Music currentlyPlayed;

public static void play()
{
    if(getSoundEnabled() != false)
    {
        if(currentlyPlayed != null)
        {
            if(currentlyPlayed.isPlaying() == false)
            {
                currentlyPlayed.play();
            }
        }
    }
}

public static void initialize()
{
    Resources.soundMainMenuTheme = Gdx.audio.newMusic(Gdx.files.internal("data/main_menu.mp3"));
    Resources.soundGameTheme = Gdx.audio.newMusic(Gdx.files.internal("data/game.mp3")); 
    Resources.soundMainMenuTheme.setLooping(true);
    Resources.soundGameTheme.setLooping(true);
}

public static void stop()
{
    if(currentlyPlayed != null)
    {
        if(currentlyPlayed.isPlaying() == true)
        {
            currentlyPlayed.stop();
        }
    }
}

public static void pause()
{
    if(getSoundEnabled() != false)
    {
        if(currentlyPlayed != null)
        {
            if(currentlyPlayed.isPlaying() == true)
            {
                currentlyPlayed.pause();
            }
        }
    }
}

public static void switchMusic(Screen screen)
{
    if(screenThemes.get(screen) != currentlyPlayed)
    {
        if(screenThemes.get(screen) != null)
        {
            stop();
            currentlyPlayed = screenThemes.get(screen);
            play();
        }
    }
}

public static void dispose()
{
    Resources.soundMainMenuTheme.dispose();
    Resources.soundGameTheme.dispose();
    screenThemes = null;
}

public static Map<Screen, Music> getScreenThemes()
{
    return screenThemes;
}