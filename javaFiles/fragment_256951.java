@GET
    @Path("/audio")
    @Produces("audio/mpeg")
    public Response getAudio(
            @DefaultValue("C:\\Users\\Ben\\Music\\sample.mp3") @QueryParam("file") String file,
            @DefaultValue("medium") @QueryParam("quality") String quality) throws EncoderException, IOException {
        File song = new File(file);
        File rootMusicDir = new File(AUDIO_PATH);
        File rootVideoDir = new File(VIDEO_PATH);
        if (!directoryService.isSubDirectory(rootMusicDir, song) && !directoryService.isSubDirectory(rootVideoDir, song)) {
            return Response.status(500).build();
        }

        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        if (quality.equalsIgnoreCase("high")) {
            audio.setBitRate(new Integer(256000));
            audio.setChannels(new Integer(2));
            audio.setSamplingRate(new Integer(44100));
        } else if (quality.equalsIgnoreCase("medium")) {
            audio.setBitRate(new Integer(128000));
            audio.setChannels(new Integer(2));
            audio.setSamplingRate(new Integer(44100));
        } else {
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));
        }

        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();

        String random = new BigInteger(130, new SecureRandom()).toString(32);
        File songMP4 = new File(TEMP_PATH + file.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+") + random);
        encoder.encode(song, songMP4, attrs);
        return Response.ok().entity(songMP4).build();
    }