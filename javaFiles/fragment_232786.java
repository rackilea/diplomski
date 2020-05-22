byte[] rawImage = null;
    try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        ImageIO.write( bi, "jpg", baos );

        baos.flush();
        rawImage = baos.toByteArray();
    }

    return rawImage;