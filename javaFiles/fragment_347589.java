pipeline.addLast("deflater", ZlibCodecFactory.newZlibEncoder(ZlibWrapper.GZIP));
pipeline.addLast("inflater", ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));

pipeline.addLast("framer", new DelimiterBasedFrameDecoder(
        8192, Delimiters.lineDelimiter()));


pipeline.addLast("decoder", new MyStringDecoder());
pipeline.addLast("encoder", new MyStringEncoder());