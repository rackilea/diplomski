while ((frameHeader = bs.readFrame()) != null) {
    short[] pcm = getPCM(frameHeader, bs);

    bs.closeFrame();

    .. more ..