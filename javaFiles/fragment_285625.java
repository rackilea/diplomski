ICC_Profile cmyk = ...;
ICC_Profile sRGB = ...;

ColorConvertOp cco = new ColorConvertOp(sRGB, cmyk);

Raster rgbRaster = ...;
WritableRaster cmykRaster = cco.filter(rgbRaster, null); 

// Or alternatively, if you have a BufferedImage input
BufferedImage rgbImage = ...;
BufferedImage cmykImage = cco.filter(rgbImage, null);