synth = MidiSystem.getSynthesizer();

    if (synth instanceof com.sun.media.sound.SoftSynthesizer) {
        Map<String, Object> params = Collections.singletonMap("jitter correction", false);
        ((com.sun.media.sound.SoftSynthesizer) synth).open(null, params);
    } else {
       synth.open();
    }