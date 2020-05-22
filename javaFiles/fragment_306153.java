BufferedImage image = ImageIO.read(new File(path));
JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(new FileOutputStream(new File(path)));
JPEGEncodeParam jpegEncodeParam = jpegEncoder.getDefaultJPEGEncodeParam(image);
jpegEncodeParam.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
jpegEncoder.setJPEGEncodeParam(jpegEncodeParam); jpegEncodeParam.setQuality(0.75f, false);
jpegEncodeParam.setXDensity(300); jpegEncodeParam.setYDensity(300);
jpegEncoder.encode(image, jpegEncodeParam);
image.flush();