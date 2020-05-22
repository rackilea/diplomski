final GcsInputChannel inputChannel;
final BufferedInputStream bufferedInputStream;
final GZIPInputStream compressedData;
final InputStream inputStream;

final MusicList musicList;

logger.info("Receiving the object");
try {

    inputChannel = gcsService.openReadChannel(gcsFilename, 0);
    bufferedInputStream = new BufferedInputStream(inputStream = Channels.newInputStream(inputChannel));
    compressedData = new GZIPInputStream(bufferedInputStream);
    musicList = new Wire(MusicList.class).parseFrom(compressedData, MusicList.class);
} catch (IOException e) {
    e.printStackTrace();
    return Collections.emptyList(); //fail
}