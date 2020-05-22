for (int i = 0; i < buffsize; i++) {
    short s = (amp * Math.sin(ph));
    if (s > 0.0) {
        sample[i] = 32767;
    };

    if (s < 0.0) {
        sample[i] = -32767;
    }
    ph += twopi * fr / sr;
}