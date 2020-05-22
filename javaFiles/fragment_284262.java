public void addExifMetadata(File jpegImageFile, File dst)
            throws IOException, ImageReadException, ImageWriteException {
        OutputStream os = null;
        try {
            TiffOutputSet outputSet = new TiffOutputSet();

            TiffOutputField colorspace = TiffOutputField.create(
                        TiffConstants.EXIF_TAG_COLOR_SPACE, outputSet.byteOrder, new Integer(1));
            TiffOutputDirectory exifDirectory = outputSet.getOrCreateExifDirectory();
            exifDirectory.add(colorspace);

            os = new FileOutputStream(dst);
            os = new BufferedOutputStream(os);
            new ExifRewriter().updateExifMetadataLossless(jpegImageFile, os, outputSet);

            os.close();
            os = null;
        } finally  {
            if (os != null)
                try {
                    os.close();
                } catch (IOException e) {

                }
        }
    }