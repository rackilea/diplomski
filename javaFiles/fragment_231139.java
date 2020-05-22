public class MyGame extends Game
{
    private static Preferences preferences;

    @Override
    public void create()
    {
        ... 
        preferences = Gdx.app.getPreferences(Resources.preferencesName);
        ...
    }

    public static Preferences getPreferences()
    {
        return preferences;
    }
}