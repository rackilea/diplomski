// sRGB
Color opaqueRed = Color.valueOf(0xffff0000); // from a color int
Color translucentRed = Color.valueOf(1.0f, 0.0f, 0.0f, 0.5f);

// Wide gamut color
ColorSpace sRgb = ColorSpace.get(ColorSpace.Named.SRGB);
@ColorLong long p3 = Color.pack(1.0f, 1.0f, 0.0f, 1.0f, sRgb);
Color opaqueYellow = Color.valueOf(p3); // from a color long

// CIE L*a*b* color space
ColorSpace lab = ColorSpace.get(Named.CIE_LAB);
Color green = Color.valueOf(100.0f, -128.0f, 128.0f, 1.0f, lab);

mView.setBackgroundColor(opaqueRed.toArgb());
mView2.setBackgroundColor(green.toArgb());
mView3.setBackgroundColor(translucentRed.toArgb());
mView4.setBackgroundColor(opaqueYellow.toArgb());