FrameBuffer frameStream = new FrameBuffer(austream); //austream is the audiostream
 int frame = frameStream.numberFrames() - 1;
 while (frame >= 0) {
      auline.write(frameStream.getFrame(frame), 0, frameStream.frameSize());
      frame--;
 }