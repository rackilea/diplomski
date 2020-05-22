public static Duration getDuration(File file) {
    val audioInputStream = AudioSystem.getAudioInputStream(file);
    val fileFormat = AudioSystem.getAudioFileFormat(file);  
    long frames = fileFormat.getFrameLength(); // I get the frame length from file format, not InputStream
    val format = audioInputStream.getFormat();
    double durationInSeconds = (frames) / format.getFrameRate();
    return Duration.ofSeconds(Math.round(durationInSeconds));
}