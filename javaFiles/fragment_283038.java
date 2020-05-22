final ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
// specifies where the jpg image has to be written
writer.setOutput(new FileImageOutputStream(
  new File(folder.toString() + "/" + filename + ".jpg")));

// writes the file with given compression level 
// from your JPEGImageWriteParam instance
writer.write(null, new IIOImage(capture, null, null), jpegParams);