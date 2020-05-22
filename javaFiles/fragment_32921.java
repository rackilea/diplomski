Iterator<ImageReader> iter = ImageIO.getImageReaders(stream);

        Exception lastException = null;
        while (iter.hasNext()) {
            ImageReader reader = null;
            try {
                reader = (ImageReader)iter.next();
                ImageReadParam param = reader.getDefaultReadParam();
                reader.setInput(stream, true, true);
                Iterator<ImageTypeSpecifier> imageTypes = reader.getImageTypes(0);
                while (imageTypes.hasNext()) {
                    ImageTypeSpecifier imageTypeSpecifier = imageTypes.next();
                    int bufferedImageType = imageTypeSpecifier.getBufferedImageType();
                    if (bufferedImageType == BufferedImage.TYPE_BYTE_GRAY) {
                        param.setDestinationType(imageTypeSpecifier);
                        break;
                    }
                }
                bufferedImage = reader.read(0, param);
                if (null != bufferedImage) break;
            } catch (Exception e) {
                lastException = e;
            } finally {
                if (null != reader) reader.dispose();               
            }
        }
        // If you don't have an image at the end of all readers
        if (null == bufferedImage) {
            if (null != lastException) {
                throw lastException;
            }
        }