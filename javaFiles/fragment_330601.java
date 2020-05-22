Encoder encoder = new Encoder();
    EncodingAttributes attributes = new EncodingAttributes();
    attributes.setFormat("wav");
    AudioAttributes audio = new AudioAttributes();
    audio.setBitRate(new Integer(64000));
    audio.setChannels(new Integer(1));
    audio.setSamplingRate(new Integer(22050));
    attributes.setAudioAttributes(audio);

    File source = new File("mysong.mp3");
    File target = new File("mysong.wav");
    try {
        encoder.encode(source, target, attributes);
    } catch (IllegalArgumentException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (InputFormatException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (EncoderException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }