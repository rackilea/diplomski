// Read image to Mat as before
Mat rgba = ...;
Imgproc.cvtColor(rgba, rgba, Imgproc.COLOR_RGB2GRAY, 0);

// Create an empty image in matching format
BufferedImage gray = new BufferedImage(rgba.width(), rgba.height(), BufferedImage.TYPE_BYTE_GRAY);

// Get the BufferedImage's backing array and copy the pixels directly into it
byte[] data = ((DataBufferByte) gray.getRaster().getDataBuffer()).getData();
rgba.get(0, 0, data);