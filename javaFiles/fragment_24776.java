// main
// get launchpad devices, open them

MyMidiDevice myDevice = new MyMidiDevice();

inputDevice.getTransmitter().setReceiver(myDevice);
myDevice.setReceiver(outputDevice.getReceiver());