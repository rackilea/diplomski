// create a Xuggler container object
    IContainer container = IContainer.make();
    if(container.open(file.getPath(),IContainer.Type.READ,null) < 0) {
        return false;
    }

    // query how many streams the call to open found
    boolean isH264 = false;
    boolean isAAC = false;

    int numStreams = container.getNumStreams();
    for(int i = 0; i < numStreams; i++)
    {
      // find the stream object
      IStream stream = container.getStream(i);
      // get the pre-configured decoder that can decode this stream;
      IStreamCoder coder = stream.getStreamCoder();

      if (coder.getCodecID() == ID.CODEC_ID_H264)  {
          isH264 = true;
      }
      if (coder.getCodecID() == ID.CODEC_ID_AAC)  {
          isAAC = true;
      }
    }

    if (container !=null)
    {
      container.close();
      container = null;
    }
    return isH264 && isAAC;