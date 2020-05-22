Decoder decoder = new Decoder();
while (!done) {
  Header frameHeader = bitStream.readFrame();
  if (frameHeader == null) {
            done = true;
  }
  else {
     SampleBuffer output = (SampleBuffer) decoder.decodeFrame(frameHeader, bitStream);
            short[] next = output.getBuffer();
            for(int i=0; i<next.length; i++) System.out.print(" "+next[i]);
            pcmOut = concatArrays(pcmOut, next);
            //do whatever with your samples
  }