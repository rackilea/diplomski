for (int n=0; n<20; n++){
  ByteBuffer bb = encoder.encode(CharBuffer.wrap(msg+'\0'));
  if(sc.write(bb) > 0 && bb.remaining() == 0) {
    // all data sent
  } else {
    // could not send all data.
  }
  bb.rewind();
}