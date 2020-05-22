int color = image.getRGB(x, y);

// extract each color component
int red   = (color >>> 16) & 0xFF;
int green = (color >>>  8) & 0xFF;
int blue  = (color >>>  0) & 0xFF;

// calc luminance in range 0.0 to 1.0; using SRGB luminance constants
float luminance = (red * 0.2126f + green * 0.7152f + blue * 0.0722f) / 255;

// choose brightness threshold as appropriate:
if (luminance >= 0.5f) {
    // bright color
} else {
    // dark color
}