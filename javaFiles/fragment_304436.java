try (SeekableStream seekableStream = new FileSeekableStream(filename)){
  TIFFDecodeParam param = null;
  ImageDecoder dec = ImageCodec.createImageDecoder("tiff", seekableStream, param);
  // convert to buffered image if desired
  return new RenderedImageAdapter(dec.decodeAsRenderedImage()).getAsBufferedImage(); // convert to buffered image
}