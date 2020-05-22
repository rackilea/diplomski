frame = vm.getCurrentFrame();//here I get my frame of the current image I wanna send

StringBuffer header = createHeader(frame.getJpegBytes().length);


byte[] headerBytes = header.toString().getBytes();

byte[] imageBytes = frame.getJpegBytes();
// create a newImage array that is the size of the two arrays
byte[] newImage = new byte[headerBytes.length + imageBytes.length];
// copy headerBytes into start of newImage (from pos 0, copy headerBytes.length bytes)
System.arraycopy(headerBytes, 0, newImage, 0, headerBytes.length);

// copy imageBytes into end of newImage (from pos headerBytes.length, copy imageBytes.length bytes)
System.arraycopy(imageBytes, 0, newImage, headerBytes.length, imageBytes.length);


output.write(newImage,0,newImage.length);
output.flush();