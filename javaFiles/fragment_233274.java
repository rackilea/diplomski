DataBufferByte buffer = (DataBufferByte) stegoImage.getRater().getDataBuffer();
byte[] data = buffer.getData(); // signed gray values in linear gray space

// Access each pixel
byte signedGrayPixelValue = data[x + y * stegoImage.getWidth()]; // [-128...127]

// Alternatively
int grayPixelValue = data[x + y * stegoImage.getWidth()] & 0xff; // [0...255]