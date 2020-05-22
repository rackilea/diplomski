// Not really necessary. Receives a callback when/if start() has succeeded.
midiDriver.setOnMidiStartListener(listener);
// Starts the driver.
midiDriver.start();
// Receives the driver's config info.
midiDriver.config();
// Stops the driver.
midiDriver.stop();
// Just calls write().
midiDriver.queueEvent(event);
// Sends a MIDI event to the synthesizer.
midiDriver.write(event);