MediaPlayer mp;
char[] currentNotes;
int noteIndex;
// Create the mp in onCreate and register your onCompletion callback

@Override
public void onClick(View v) {
    EditText keyInput = (EditText) findViewById(R.id.key);
    String notes = keyInput.getText().toString();
    currentNotes = notes.toCharArray();
    noteIndex = 0;
    mp.setDataSource(getNoteResource(currentNotes[0]));
    mp.start();
}

// Convert tone values into 
public int getNoteResource(char tone) {…}

@Override
public void onCompletion(MediaPlayer mp) {
    if(++noteIndex < currentNotes.length) {
        mp.setDataSource(getNoteResource(currentNotes[noteIndex]));
        mp.start();
    }
}