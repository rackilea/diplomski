public void drawFromArrayList(ArrayList<Pair<Float,Float>> points) {
    int pointCount = points.size();
    if (pointCount < 2) {
        return;
    }
    for (int i=0;i<pointCount;i++) {
        float touchX = points.get(i).first, touchY = points.get(i).second;
        if(i==0) {
            drawPath.moveTo(touchX, touchY);
        }
        drawPath.lineTo(touchX, touchY);
        if(i==pointCount-1) {
            drawCanvas.drawPath(drawPath, drawPaint);
            drawPath.reset();
        }
    }
}