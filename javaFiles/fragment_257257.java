public class Tone {
    public static void main(String[] args) {
        double hz       = Double.parseDouble(args[0]);    // frequency in Hz
        double duration = Double.parseDouble(args[1]);    // duration in seconds

        int n = (int) (StdAudio.SAMPLE_RATE * duration);

        // build sine wave with desired frequency
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }

        // play using standard audio
        StdAudio.play(a);
    }
}