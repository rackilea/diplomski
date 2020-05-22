for (Info note : notes) {
    channels[0].noteOn(note.note, note.velocity);
    try {
        Thread.sleep(note.duration);
    } catch (InterruptedException e) {
    }
    channels[0].noteOff(note.note);
}