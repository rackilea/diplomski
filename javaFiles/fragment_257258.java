public static void main(String[] args) {
    //StdIn.fromFile("data/a2song.txt");
    double[] values = new double[] {278.4375, 278.4375, 417.1849, 417.1849, 468.2742, 468.2742, 417.1849};
    for(double value : values) {
        playTone (value,.4);
    }
    StdAudio.close();
    System.exit(0);
}

public static void playTone(double frequency, double duration) {
    int n = (int) (StdAudio.SAMPLE_RATE * duration);
    // build sine wave with desired frequency
    double[] a = new double[n+1];
    for (int i = 0; i <= n; i++) {
        a[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
    }
    // play using standard audio
    StdAudio.play(a);
}