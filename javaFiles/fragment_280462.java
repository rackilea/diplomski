/**
 * Gets a list of all audio output devices in the system
 */
public static List<Mixer> getAvailableAudioOutputDevices() {
    final ArrayList<Mixer> available = new ArrayList<>();
    final Mixer.Info[] devices = AudioSystem.getMixerInfo();
    final Line.Info sourceInfo = new Line.Info(SourceDataLine.class);
    for (int i=0; i<devices.length; ++i) {
        final Mixer.Info mixerInfo = devices[i];
        final Mixer mixer = AudioSystem.getMixer(mixerInfo);
        if (mixer.isLineSupported(sourceInfo)) {
            // the device supports output, add as suitable
            available.add(mixer);
        }
    }
    return available;
}