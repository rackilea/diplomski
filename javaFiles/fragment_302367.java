int tick = 0;
    for (int i = 0; i < clickSamples.length; i++) {
        tick++;
        if (tick >= bufferSize/SAMPLE_SIZE) {
            line.write(clickSamples, i-tick+1, tick);
            buffer.clear();
            tick = 0;
        }
    }