AudioInputStream stream = AudioSystem.getAudioInputStream("...file...");
AudioFormat format = stream.getFormat();
// find out how many bytes you have to skip, this depends on bytes per frame (a.k.a. frameSize)
int secondsToSkip = 10;
long bytesToSkip = format.getFrameSize() * ((int)format.getFrameRate()) * secondsToSkip;
// now skip until the correct number of bytes have been skipped
int justSkipped = 0;
while (bytesToSkip > 0 && (justSkipped = stream.skip(bytesToSkip)) > 0) {
    bytesToSkip -= justSkipped;
}
// then proceed with writing to your line like you have done before
[...]