byte[] newImage = new byte[rgbImage.length];

    for (int i = 0; i < rgbImage.length; i += 3) {
        newImage[i] = (byte) (rgbImage[i] * 0.299 + rgbImage[i + 1] * 0.587
                + rgbImage[i + 2] * 0.114);
        newImage[i+1] = newImage[i];
        newImage[i+2] = newImage[i];
    }