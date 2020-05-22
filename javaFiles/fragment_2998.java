@With(MP3Headers.class)
public static Result test() {
    final int begin, end;
    final boolean isRangeReq;
    response().setHeader("Accept-Ranges", "bytes");
    if (request().hasHeader("RANGE")) {
        isRangeReq = true;
        String[] range = request().getHeader("RANGE").split("=")[1].split("-");
        begin = Integer.parseInt(range[0]);
        if (range.length > 1) {
            end = Integer.parseInt(range[1]);
        } else {
            end = song.length-1;
        }
        response().setHeader("Content-Range", String.format("bytes %d-%d/%d", begin, end, song.length));
    } else {
        isRangeReq = false;
        begin = 0;
        end = song.length - 1;
    }

    Chunks<byte[]> chunks = new ByteChunks() {
        public void onReady(Chunks.Out<byte[]> out) {
            if(isRangeReq) {
                out.write(Arrays.copyOfRange(song, begin, end));
            } else {
                out.write(song);
            }
            out.close();
        }
    };
    response().setHeader("Content-Length", (end - begin + 1) + "");
    if (isRangeReq) {
        return status(206, chunks);
    } else {
        return status(200, chunks);
    }
}