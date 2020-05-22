public MyOval(int x1, int y1, int x2, int y2, Color color, boolean isFilled) {
    this.x1 = Math.min(x1, x2);
    this.y1 = Math.min(y1, y2);
    this.x2 = Math.max(x1, x2);
    this.y2 = Math.max(y1, y2);;
    myColor = color;
    this.isFilled = isFilled;
}