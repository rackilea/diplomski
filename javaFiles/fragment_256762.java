// Obtain information about all the installed synthesizers.
Vector synthInfos;
MidiDevice device;
MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
for (int i = 0; i < infos.length; i++) {
  try {
    device = MidiSystem.getMidiDevice(infos[i]);
  } catch (MidiUnavailableException e) {
      // Handle or throw exception...
  }
  if (device instanceof Synthesizer) {
    synthInfos.add(infos[i]);
  }
}
// Now, display strings from synthInfos list in GUI.