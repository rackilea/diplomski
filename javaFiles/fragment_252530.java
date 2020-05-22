public class Audio {

    private Clip clip;

    protected Audio() {
    }

    public Audio(File source) throws LineUnavailableException, MalformedURLException, IOException, UnsupportedAudioFileException {
        this(source.toURI().toURL());
    }

    public Audio(URL source) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        this(source.openStream());
    }

    public Audio(InputStream source) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        init(source);
    }

    protected void init(File source) throws LineUnavailableException, MalformedURLException, IOException, UnsupportedAudioFileException {
        init(source.toURI().toURL());
    }

    protected void init(URL source) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        init(source.openStream());
    }

    protected void init(InputStream source) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(source));
    }

    public void setRepeats(boolean repeats) {
        clip.loop(repeats ? Clip.LOOP_CONTINUOUSLY : 1);
    }

    public void reset() {
        clip.stop();
        clip.setFramePosition(0);
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public boolean isPlaying() {
        return clip.isActive();
    }
}