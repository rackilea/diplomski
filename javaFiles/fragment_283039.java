// use IIORegistry to get the available services
IIORegistry registry = IIORegistry.getDefaultInstance();
// return an iterator for the available ImageWriterSpi for jpeg images
Iterator<ImageWriterSpi> services = registry.getServiceProviders(ImageWriterSpi.class,
                                                 new ServiceRegistry.Filter() {   
        @Override
        public boolean filter(Object provider) {
            if (!(provider instanceof ImageWriterSpi)) return false;

            ImageWriterSpi writerSPI = (ImageWriterSpi) provider;
            String[] formatNames = writerSPI.getFormatNames();
            for (int i = 0; i < formatNames.length; i++) {
                if (formatNames[i].equalsIgnoreCase("JPEG")) {
                    return true;
                }
            }

            return false;
        }
    },
   true);
//...assuming that servies.hasNext() == true, I get the first available service.
ImageWriterSpi writerSpi = services.next();
ImageWriter writer = writerSpi.createWriterInstance();

// specifies where the jpg image has to be written
writer.setOutput(new FileImageOutputStream(
  new File(folder.toString() + "/" + filename + ".jpg")));

// writes the file with given compression level 
// from your JPEGImageWriteParam instance
writer.write(null, new IIOImage(capture, null, null), jpegParams);