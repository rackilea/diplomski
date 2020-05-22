ControllerEventListener controllerEventListener = new ControllerEventListener() {
   public void controlChange(ShortMessage event) {
      // TODO convert the event into a readable/desired output
      System.out.println(event);
   }
};

Sequencer sequencer = MidiSystem.getSequencer();
int[] controllersOfInterest = { 1, 2, 4 };
sequencer.addControllerEventListener(controllerEventListener, controllersOfInterest);