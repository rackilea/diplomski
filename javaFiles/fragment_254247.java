public static List<AudioFormat> getSupportedAudioFormats() {
    List<AudioFormat> result = new ArrayList<>();
    for (Line.Info info : AudioSystem.getSourceLineInfo(
                new Line.Info(SourceDataLine.class))) {
        if (info instanceof SourceDataLine.Info) {
            Collections.addAll(result, ((SourceDataLine.Info) info).getFormats());
        }
    }
    return result;
}