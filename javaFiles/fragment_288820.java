private void pukeMeAChart(){
    try {
        mContents.transform(Matrix.getTranslateInstance(375,525));
        drawSlice(Color.YELLOW, 60, 0, 69);
        mContents.fill();
        drawSlice(Color.BLUE, 60, 69, 117);
        drawSlice(Color.RED, 60, 117, 181);
        mContents.fill();
        drawSlice(Color.WHITE, 60, 181, 208);
        mContents.fill();
        drawSlice(Color.GREEN, 60, 208, 272);
        mContents.fill();
        drawSlice(Color.YELLOW, 60, 272, 336);
        drawSlice(Color.BLUE, 60, 336, 360);
        mContents.fill();
    } catch(IOException e ){}
}