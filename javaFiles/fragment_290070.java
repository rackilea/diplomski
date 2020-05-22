Color c = new Color(0x15, 0x89, 0xFF);

// Get saturation and brightness.
float[] hsbVals = new float[3];
Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsbVals);

// Pass .5 (= 180 degrees) as HUE
c = new Color(Color.HSBtoRGB(0.5f, hsbVals[1], hsbVals[2]));