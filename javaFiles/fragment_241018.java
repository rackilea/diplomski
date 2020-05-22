double anglerotation = 1d / 12; // 30 /360

Color mainColor = new Color(174, 235, 18);

float[] hsbLeftColor = Color.RGBtoHSB(mainColor.getRed(), mainColor.getGreen(), mainColor.getBlue(), null);
hsbLeftColor[0] -= anglerotation;
Color leftColor = new Color(Color.HSBtoRGB(hsbLeftColor[0], hsbLeftColor[1], hsbLeftColor[2]));

float[] hsbRightColor = Color.RGBtoHSB(mainColor.getRed(), mainColor.getGreen(), mainColor.getBlue(), null);
hsbRightColor[0] += anglerotation;
Color rightColor = new Color(Color.HSBtoRGB(hsbRightColor[0], hsbRightColor[1], hsbRightColor[2]));