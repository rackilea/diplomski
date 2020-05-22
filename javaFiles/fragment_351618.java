int min = 0;
    int max = 0;
    for (int sample : samples[0]) {

        max = Math.max(max, sample);
        min = Math.min(min, sample);

    }