@Override
protected void processTextPosition (TextPosition textPosition) {

    try {

        PDGraphicsState graphicsState = getGraphicsState();
        System.out.println(graphicsState.getNonStrokingColor().toRGB());

    }

    catch (Exception ioe) {}

}