import javax.sound.sampled.*;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AlternatingTones {

    public static void main(final String[] args) throws LineUnavailableException, InterruptedException {

        final Clip clip0 = createOneSecondClip(440f);
        final Clip clip1 = createOneSecondClip(16000f);

        clip0.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                clip1.setFramePosition(0);
                clip1.start();
            }
        });
        clip1.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                clip0.setFramePosition(0);
                clip0.start();
            }
        });
        clip0.start();

        // prevent JVM from exiting
        Thread.sleep(10000000);
    }

    private static Clip createOneSecondClip(final float frequency) throws LineUnavailableException {
        final Clip clip = AudioSystem.getClip();
        final AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100f, 16, 1, 2, 44100, true);
        final ByteBuffer buffer = ByteBuffer.allocate(44100 * format.getFrameSize());
        final ShortBuffer shortBuffer = buffer.asShortBuffer();
        final float cycleInc = frequency / format.getFrameRate();
        float cyclePosition = 0f;
        while (shortBuffer.hasRemaining()) {
            shortBuffer.put((short) (Short.MAX_VALUE * Math.sin(2 * Math.PI * cyclePosition)));
            cyclePosition += cycleInc;
            if (cyclePosition > 1) {
                cyclePosition -= 1;
            }
        }
        clip.open(format, buffer.array(), 0, buffer.capacity());
        return clip;
    }
}