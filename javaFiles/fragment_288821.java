private void pukeMeAChart(){
    try {
        mContents.saveGraphicsState();
        mContents.transform(Matrix.getTranslateInstance(375,525));
        drawSlice(Color.YELLOW, 60, 0, 69);
        drawSlice(Color.BLUE, 60, 69, 117);
        drawSlice(Color.RED, 60, 117, 181);
        drawSlice(Color.WHITE, 60, 181, 208);
        drawSlice(Color.GREEN, 60, 208, 272);
        drawSlice(Color.YELLOW, 60, 272, 336);
        drawSlice(Color.BLUE, 60, 336, 360);
        mContents.restoreGraphicsState();
    } catch(IOException e ){}
}