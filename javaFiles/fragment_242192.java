TIFFEncodeParam params = new TIFFEncodeParam();
OutputStream out = new FileOutputStream(output_dir + image_name + ".tif"); 
ImageEncoder encoder = ImageCodec.createImageEncoder("tiff", out, params);
Vector vector = new Vector();   
for (int i = 0; i < numImages; i++) {
    vector.add(image[i]); 
}
params.setExtraImages(vector.listIterator(1)); // this may need a check to avoid IndexOutOfBoundsException when vector is empty
encoder.encode(image[0]); 
out.close();