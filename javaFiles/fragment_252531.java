public class MainTheme extends Audio {

    public MainTheme() throws LineUnavailableException, MalformedURLException, IOException, UnsupportedAudioFileException {
        init(getClass().getResource("textures/Main_theme.wav"));
    }

}