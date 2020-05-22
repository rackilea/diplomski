AudioFormat fmt = musicInputStream.getFormat();

long framesRead = totalBytes / fmt.getFrameSize();
long totalFrames = musicInputStream.getFrameLength();

double totalSeconds = (double) totalFrames / fmt.getSampleRate();

double elapsedSeconds =
    ((double) framesRead / (double) totalFrames) * totalSeconds;