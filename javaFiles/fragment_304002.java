IIOMetadata iiom = ir.getImageMetadata(i);
    TIFFDirectory dir = TIFFDirectory.createFromMetadata(iiom);

    TIFFField fieldXRes = dir.getTIFFField(BaselineTIFFTagSet.TAG_X_RESOLUTION);
    TIFFField fieldYRes = dir.getTIFFField(BaselineTIFFTagSet.TAG_Y_RESOLUTION);

    int xRes = fieldXRes.getAsInt(0);
    int yRes = fieldYRes.getAsInt(0);