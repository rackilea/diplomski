encoding:
for(int i = 0; i < height; i++){
    for(int j = 0; j < width; j++){
        Color c = new Color(image.getRGB(j, i));

        int red = binaryToInteger(insertMessage(integerToBinary((int)(c.getRed())),numLSB));
        int green = binaryToInteger(insertMessage(integerToBinary((int)(c.getGreen())),numLSB));
        int blue = binaryToInteger(insertMessage(integerToBinary((int)(c.getBlue())),numLSB));

        Color newColor = new Color(red,green,blue);
        image.setRGB(j,i,newColor.getRGB());

        if (count == binarizedMessage.length()) break encoding;
    }
}