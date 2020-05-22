// The important part: Create in-memory stream
ByteArrayOutputStream compressed = new ByteArrayOutputStream();
ImageOutputStream outputStream = ImageIO.createImageOutputStream(compressed);

// NOTE: The rest of the code is just a cleaned up version of your code

// Obtain writer for JPEG format
ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();

// Configure JPEG compression: 70% quality
ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
jpgWriteParam.setCompressionQuality(0.7f);

// Set your in-memory stream as the output
jpgWriter.setOutput(outputStream);

// Write image as JPEG w/configured settings to the in-memory stream
// (the IIOImage is just an aggregator object, allowing you to associate
// thumbnails and metadata to the image, it "does" nothing)
jpgWriter.write(null, new IIOImage(image, null, null), jpgWriteParam);

// Dispose the writer to free resources
jpgWriter.dispose();

// Get data for further processing...
byte[] jpegData = compressed.toByteArray();