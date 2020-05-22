private void drawDots(int radius, int numDots){
    double y;
    double x;
    double xMax;

    for (int q = 0; q < numDots; q++){
        // y is chosen randomly
        y = -radius + random() * (radius + radius + 1);

        // x must respect x² + y² < r²
        xMax = pow((pow(radius,2)-pow(ycord,2)), 0.5);
        x = random() * 2 * xMax - xMax;

        turt.moveTo(x, y);
        turt.penDown();
        turt.forward(0);
        turt.penUp();
    }
}