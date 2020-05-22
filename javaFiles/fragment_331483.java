static Mixer getMixerByName(String toFind) {
    for(Mixer.Info info : AudioSystem.getMixerInfo()) {
        if(toFind.equals(info.getName())) {
            return AudioSystem.getMixer(info);
        }
    }
    return null;
}