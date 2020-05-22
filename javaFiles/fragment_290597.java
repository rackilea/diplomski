@Override public void paint(Graphics g) {
     Image bufferImage = createImage(300, 300);  
     paint300(bufferImage.getGraphics());
     int width = getWidth();
     int height = getHeight(); 
     CropImageFilter crop = 
         new CropImageFilter((300 - width)/2, (300 - height)/2 , width, height);
     FilteredImageSource fis = new FilteredImageSource(bufferImage, crop);
     Image croppedImage = createImage(fis);
     g.drawImage(croppedImage, 0, 0, null);
}