public void drawCircle(G_Graphics graphics, G_Color color){
    double degreesToRadians = Math.PI / 180.0;
    for(int degrees=0; degrees<=360; degrees++)
    {
        double radians = degreesToRadians * degrees;
        int X = (int)(sX + Math.cos(radians) * radius);
        int Y = (int)(sY + Math.sin(radians) * radius);           
        graphics.putPixel(X, Y, color);
    }
}