// this is a method on Scale
public int getScaleIndex(Pitch pitch) {
    return notesInScale.indexOf(pitch);
}
...
public Note getNoteByScale(Scale scale, int transposeFactor) {
    // rename to "newPitchIndex" to distinguish from the actual new Pitch object
    int newPitchIndex = scale.getScaleIndex(this.pitch) + transposeFactor;
    // only use pitch indexes for a scale in the range 0-6
    if (newPitchIndex > 6) newPitchIndex -=7;
    else if (newPitchIndex < 0) newPitchIndex += 7;
    // create the new Pitch object
    Pitch newPitch = scale.getNotesInScale().get(newPitchIndex);

    //  Get the note numbers (relative to C)
    int noteNumber = this.pitch.getNoteNumber();
    int newNoteNumber = newPitch.getNoteNumber();
    int newOctave = this.octave;
    if      (transposeFactor > 0 && newNoteNumber < noteNumber) newOctave++;
    else if (transposeFactor < 0 && newNoteNumber > noteNumber) newOctave--;

    return Note.createNote(newPitch, newOctave, this.duration);
}