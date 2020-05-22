public class MainActivity extends ActionBarActivity {

private MediaPlayer newTune;
    public void play() {
    newTune = MediaPlayer.create(this, R.raw.b);

    newTune.start();
    }
}