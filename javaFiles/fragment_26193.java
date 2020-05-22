startTick = 0;

while(itr.hasNext()) {
   [...]
   track.add(new MidiEvent(noteOnMsg,startTick));
   track.add(new MidiEvent(noteOffMsg,startTick + how_long_the_note_is_played));
   startTick += difference_between_this_note_and_the_next;
   [...]
}