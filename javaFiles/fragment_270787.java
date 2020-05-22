@Test
public void transposeUpGivesCorrectPitch() {
    //                 ┌~1▼
    // |D  E  F♯ G  A  B ║C♯|D  E  F♯ G  A  B ║C♯ |
    Note original = Note.createNote(Pitch.B, 5, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.D_MAJOR, 1);
    Note expected = Note.createNote(Pitch.C_SHARP, 6, Duration.WHOLE);
    assertEquals(expected.getPitch(), actual.getPitch());
}

@Test
public void transposeDownGivesCorrectPitch() {
    //                 ▼1~┐                     
    // |D  E  F♯ G  A  B ║C♯|D  E  F♯ G  A  B ║C♯ |
    Note original = Note.createNote(Pitch.C_SHARP, 6, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.D_MAJOR, -1);
    Note expected = Note.createNote(Pitch.B, 5, Duration.WHOLE);
    assertEquals(expected.getPitch(), actual.getPitch());
}

@Test
public void transposeUpOutsideScaleGivesCorrectPitch() {
    //                 ┌‒1‒~2‒‒3‒‒4▼         
    // ║C  D  E  F  G  A  B ║C  D  E  F  G  A  B |
    Note original = Note.createNote(Pitch.A, 5, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.C_MAJOR, 4);
    Note expected = Note.createNote(Pitch.E, 6, Duration.WHOLE);
    assertEquals(expected.getPitch(), actual.getPitch());
}

@Test
public void transposeDownOutsideScaleGivesCorrectPitch() {
    //           ▼4‒‒3‒‒2‒‒1~┐                        
    // ║C  D  E  F  G  A  B ║C  D  E  F  G  A  B |
    Note original = Note.createNote(Pitch.C, 6, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.C_MAJOR, -4);
    Note expected = Note.createNote(Pitch.F, 5, Duration.WHOLE);
    assertEquals(expected.getPitch(), actual.getPitch());
}

@Test
public void transposeUpGivesCorrectOctave() {
    //                 ┌~1▼
    // |D  E  F♯ G  A  B ║C♯|D  E  F♯ G  A  B ║C♯ |
    Note original = Note.createNote(Pitch.B, 5, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.D_MAJOR, 1);
    Note expected = Note.createNote(Pitch.C_SHARP, 6, Duration.WHOLE);
    assertEquals(expected.getOctave(), actual.getOctave());
}

@Test
public void transposeUp2GivesCorrectOctave() {
    //                 ┌~1‒‒2‒‒3‒‒4‒‒5‒‒6‒‒7‒~1▼                     
    // |D  E  F♯ G  A  B ║C♯|D  E  F♯ G  A  B ║C♯ |
    Note original = Note.createNote(Pitch.B, 5, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.D_MAJOR, 1 + 7);
    Note expected = Note.createNote(Pitch.C_SHARP, 7, Duration.WHOLE);
    assertEquals(expected.getOctave(), actual.getOctave());
}

@Test
public void transposeDownGivesCorrectOctave() {
    //                 ▼1~┐                     
    // |D  E  F♯ G  A  B ║C♯|D  E  F♯ G  A  B ║C♯ |
    Note original = Note.createNote(Pitch.C_SHARP, 6, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.D_MAJOR, -1);
    Note expected = Note.createNote(Pitch.B, 5, Duration.WHOLE);
    assertEquals(expected.getOctave(), actual.getOctave());
}

@Test
public void transposeDown2GivesCorrectOctave() {
    //                 ▼1~‒7‒‒6‒‒5‒‒4‒‒3‒‒2‒‒1~┐                     
    // |D  E  F♯ G  A  B ║C♯|D  E  F♯ G  A  B ║C♯ |
    Note original = Note.createNote(Pitch.C_SHARP, 6, Duration.WHOLE);
    Note actual = original.getNoteByScale(Scale.D_MAJOR, -1 - 7);
    Note expected = Note.createNote(Pitch.B, 4, Duration.WHOLE);
    assertEquals(expected.getOctave(), actual.getOctave());
}

// ... and more tests are needed ...