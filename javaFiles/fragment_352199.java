import java.io.File;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class PlayMidiFromFile {

    public static void main(final String[] args) {
        try {
            final Player player = new Player();
            final Pattern pattern = MidiFileManager.loadPatternFromMidi(new File("sample.mid"));
            player.play(pattern);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}