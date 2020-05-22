String fontColor = "#0cf356";

// remove hash character from string
String rawFontColor = fontColor.substring(1,fontColor.length());

// convert hex string to int
int rgb = Integer.parseInt(rawFontColor, 16);

Color c = new Color(rgb);

float[] hsb = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);

float brightness = hsb[2];

if (brightness < 0.5) {
   // use a bright background
} else {
   // use a dark background
}