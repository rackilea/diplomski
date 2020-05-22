public class MidiPlayerTest {
    @Test
    public void playMidiTst() throws InvalidMidiDataException, IOException, MidiUnavailableException {
        Sequencer sequencer = MidiSystem.getSequencer();

        Transmitter transmitter = sequencer.getTransmitter();
        transmitter.setReceiver(new SmcReceiver());
        System.out.println(sequencer.getClass().getName());

        sequencer.open();

        sequencer.setSequence(MidiSystem.getSequence(new File("tst.midi")));


        sequencer.start();

        while(true) {
            if(sequencer.isRunning()) {
                try {
                    Thread.sleep(200); // Check every second
                } catch(InterruptedException ignore) {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("DONE!");
    }
}