private static MidiEvent createMetaMessageMidiEvent(int type, byte[] data, int length, long instant) {
    MetaMessage metaMessage = new MetaMessage();
    try {
      metaMessage.setMessage(type, data, length);
    } catch (InvalidMidiDataException e) {
    }
    return new MidiEvent(metaMessage, instant);
  }