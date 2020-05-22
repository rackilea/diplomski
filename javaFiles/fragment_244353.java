decoding:
for(int i = 0; i < height; i++){
    for(int j = 0; j < width; j++){
        Color c = new Color(image.getRGB(j, i));                  

        encodedData += getLSB(integerToBinary((int)(c.getRed())),numLSB);
        if(limit >= 8) break decoding;
        encodedData += getLSB(integerToBinary((int)(c.getGreen())),numLSB);
        if(limit >= 8) break decoding;
        encodedData += getLSB(integerToBinary((int)(c.getBlue())),numLSB);
        if(limit >= 8) break decoding;
    }
}