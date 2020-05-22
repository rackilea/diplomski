// pixel depth will be 8-bit, so there is space for 256 different (grey) values
RGB[] rgb = new RGB[256];

// build grey scale palette: 256 different grey values are generated. 
for (int i = 0; i < 256; i++) {
    rgb[i] = new RGB(i, i, i);
}

// Construct a new indexed palette given an array of RGB values.
PaletteData paletteData = new PaletteData(rgb);

// create an image with given dimensions, depth and color palette
ImageData imageData = new ImageData(1280, 1024, 8, paletteData);

// data represents the pixels of the image. This corresponds to 'b' in Your code
imageData.data = b;

// note that there are also other 'Image', e.g. java.awt.Image
org.eclipse.swt.graphics.Image image = new Image(Display.getCurrent(), imageData);

// paint
imgLabel.setImage(img);

// release operating system resources corresponding to the image
image.dispose();