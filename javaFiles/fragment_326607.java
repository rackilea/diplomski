DataPusher datapusher = null;
DataLine.Info lineinfo = null;
SourceDataLine sourcedataline = null;
lineinfo = new DataLine.Info(SourceDataLine.class, audioInputStream.getFormat());
if (!(AudioSystem.isLineSupported(lineinfo))) {
    return;
}
sourcedataline = (SourceDataLine) AudioSystem.getLine(lineinfo);
sourcedataline.addLineListener(e -> {
    if (e.getType() == LineEvent.Type.STOP) {
        // Do something on end of playback
    }
});
datapusher = new DataPusher(sourcedataline, audioInputStream);
datapusher.start();