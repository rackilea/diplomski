public void meta(MetaMessage event) {
  if (event.getType() == END_OF_TRACK_MESSAGE) {
   if (sequencer != null && sequencer.isOpen() && loop) {
       sequencer.setTickPosition(0);
       sequencer.start();
   }
  }
}