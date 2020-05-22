MidiDevice.Info[] MidiDeviceInfos = MidiSystem.getMidiDeviceInfo();
//find the suitable device number here, based on some criteria
MidiDevice MidiOutDevice = MidiSystem.getMidiDevice(MidiDeviceInfos[DEVICE_NUMBER]);
Receiver MidiOutReceiver = MidiOutDevice.getReceiver();
Sequencer MidiOutSequencer = MidiSystem.getSequencer();
//Add the new MIDI out device here.
MidiOutSequencer.getTransmitter().setReceiver(MidiOutReceiver);
MidiOutSequencer.open();