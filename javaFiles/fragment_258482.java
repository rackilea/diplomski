byte[] oneColor = {..., ..., ..., ...};

int alpha = oneColor[0] & 0xFF;
int red = oneColor[1] & 0xFF;
int green = oneColor[2] & 0xFF;
int blue = oneColor[3] & 0xFF;

System.out.println("Color: " + alpha + ", " + red + ", " + green ", " + blue);

System.out.println("Hexa color: 0x" + Integer.toHexString(alpha) + " " + Integer.toHexString(red) + " " + Integer.toHexString(green) + " " + Integer.toHexString(blue));