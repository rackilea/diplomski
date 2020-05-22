URL url = getClass().getResource("drop.wav");
AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
AudioFormat format = audioInputStream.getFormat();
DataLine.Info lineInfo = new DataLine.Info(Clip.class, format);

Mixer.Info selectedMixer = null;

for (Mixer.Info mixerInfo : AudioSystem.getMixerInfo()) {
    Mixer mixer = AudioSystem.getMixer(mixerInfo);
    if (mixer.isLineSupported(lineInfo)) {
        selectedMixer = mixerInfo;
        break;
    }
}

if (selectedMixer != null) {
    Clip clip = AudioSystem.getClip(selectedMixer); 
    [...]
}