int numBytesIn100Millis =
    ((int) (format.getFrameRate() / 10)) * format.getFrameSize();
byte[] buffer = new byte[numBytesIn100Millis];

for (;;) {
    int bytesRead = audioInputStream.read(buffer);
    if (bytesRead < 0)
        break;
    if (bytesRead < buffer.length)
        // this just fills the end of 'buffer' with 0s
        // if read() didn't fill the entire array
        Arrays.fill(buffer, bytesRead, buffer.length, ((byte) 0));

    // 'buffer' now has 100ms of audio
}