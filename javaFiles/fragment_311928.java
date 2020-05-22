long instant = 0L;

  byte[] bytesSetTempo = {0x0F, 0x42, 0x40};//1'000.000
  byte[] bytesTimeSignature = {0x05, 0x03, 0x18, 0x16};//'Time Signature/numerator: '05' = 5, denominator pow: '03' -> Pow(2, 3) = 8, MIDI Clocks :'18' = 24, number 1/32 notes per 24 MIDI clocks:'16' = 16'

  String trackNamePiano = new String("Track Name:Piano");
  byte[] bytesKeySignaturePiano = {0x02, 0x00};//'02' = 2 sharps, key: '00' = major key'
  trackPiano.add(createMetaMessageMidiEvent(0x03, trackNamePiano.getBytes(), trackNamePiano.length(), instant));
  trackPiano.add(createMetaMessageMidiEvent(0x51, bytesSetTempo, bytesSetTempo.length, instant));
  trackPiano.add(createMetaMessageMidiEvent(0x58, bytesTimeSignature, bytesTimeSignature.length, instant));
  trackPiano.add(createMetaMessageMidiEvent(0x59, bytesKeySignaturePiano, bytesKeySignaturePiano.length, instant));

  String trackNameViolin = new String("Track Name:Violin");
  byte[] bytesKeySignatureViolin = {(byte) 0xFE, 0x01};//'FE' = 2 flats, key: '01' = minor key'
  trackViolin.add(createMetaMessageMidiEvent(0x03, trackNameViolin.getBytes(), trackNameViolin.length(), instant));
  trackViolin.add(createMetaMessageMidiEvent(0x58, bytesTimeSignature, bytesTimeSignature.length, instant));
  trackViolin.add(createMetaMessageMidiEvent(0x51, bytesSetTempo, bytesSetTempo.length, instant));
  trackViolin.add(createMetaMessageMidiEvent(0x59, bytesKeySignatureViolin, bytesKeySignatureViolin.length, instant));