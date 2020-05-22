int lastY = data.nextInt();
while (data.hasNextInt()) {                 
    int nextY = data.nextInt();
    g.drawLine((x-1)*10, lastY, 10*x, nextY);
    x++;
    lastY = nextY;
}