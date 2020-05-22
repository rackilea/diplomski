public Note getNoteByScale(Scale scale, int transposeFactor) {
    // move not by more than 7
    int pitchIndex = scale.getScaleIndex(this.pitch);
    int newPitchIndex = (pitchIndex + transposeFactor) % 7;
    // and adjust negative values down from the maximum index
    if (newPitchIndex < 0) newPitchIndex += 7;
    // create the new Pitch object
    Pitch newPitch = scale.getNotesInScale().get(newPitchIndex);

    //  Get the note numbers (relative to C)
    int noteNumber = this.pitch.getNoteNumber();
    int newNoteNumber = newPitch.getNoteNumber();
    //  Get the number of whole octave changes
    int octaveChanges = transposeFactor / 7;
    int newOctave = this.octave + octaveChanges;
    //  Adjust the octave based on a larger/smaller note index relative to C
    if      (transposeFactor > 0 && newNoteNumber < noteNumber) newOctave++;
    else if (transposeFactor < 0 && newNoteNumber > noteNumber) newOctave--;

    return Note.createNote(newPitch, newOctave, this.duration);
}