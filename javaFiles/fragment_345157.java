GraphicsEnvironment ge
        = GraphicsEnvironment.getLocalGraphicsEnvironment();
GraphicsDevice gd = ge.getDefaultScreenDevice();

boolean isUniformTranslucencySupported
        = gd.isWindowTranslucencySupported(TRANSLUCENT);
boolean isPerPixelTranslucencySupported
        = gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);
boolean isShapedWindowSupported
        = gd.isWindowTranslucencySupported(PERPIXEL_TRANSPARENT);

System.out.println("Hello");

if (isUniformTranslucencySupported && isPerPixelTranslucencySupported && isShapedWindowSupported) {

    // Build window as normal...

} else {

    if (!isUniformTranslucencySupported) {
        System.err.println("Translucentancy is not support");
    }
    if (!isPerPixelTranslucencySupported) {
        System.err.println("Per Pixel Translucentancy is not support");
    }
    if (!isShapedWindowSupported) {
        System.err.println("Per Pixel Transparenancy is not support");
    }

    System.exit(0);

}