private static MidiEvent createCCData(int cc, int val, long lTick) {
    ShortMessage mm = new ShortMessage();
    mm = new ShortMessage();
    try {
        mm.setMessage(0xB0,cc,val);
    } 
    catch (InvalidMidiDataException e) {
        e.printStackTrace();
        System.exit(1);
    }
    MidiEvent me = new MidiEvent(mm,lTick);     
    return me;
}