init() {
Bitmap patternBMP = BitmapFactory.decodeResource(getResources(), resourseidofthebmpfile);
    BitmapShader patternBMPshader = new BitmapShader(patternBMP, 
        Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
}
    onDraw(...) {
    canvas.drawPath(drawPath, drawPaint);
}