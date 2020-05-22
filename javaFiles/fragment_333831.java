final TiffOutputDirectory exifDirectory = outputSet
                .getOrCreateRootDirectory();
        exifDirectory
                .removeField(ExifTagConstants.EXIF_TAG_SOFTWARE);
        exifDirectory.add(ExifTagConstants.EXIF_TAG_SOFTWARE,
                "SomeKind");