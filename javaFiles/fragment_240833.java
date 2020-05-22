double[] a = tone(440, 1.0);        // note A
double[] b = tone(523.25, 1.0);     // note C (i hope:)
for (int i = 0; i < a.length; i++) {
    a[i] = (a[i] + b[i]) / 2;
}
for (double t : a) {
    play(sdl, t);
}