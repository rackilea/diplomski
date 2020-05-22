@Override
protected void onDraw(Canvas canvas) {
    super.onDraw(canvas); // So the image you want is drawn as normal

    myMethodForDrawingAFancyHighlight(Canvas canvas); // add your special effects on top of the image
}