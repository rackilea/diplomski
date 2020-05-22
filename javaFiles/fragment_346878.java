class S extends Shape {
    final int color;
    final float radius;
    Path path = new Path();

    public S(int color, float radius) {
        this.color = color;
        this.radius = radius;
    }

    @Override
    protected void onResize(float width, float height) {
        path.reset();
        path.moveTo(0, 0);
        path.lineTo(width, height);
        path.lineTo(radius, height);
        RectF oval = new RectF(0, height - 2 * radius, 2 * radius, height);
        path.arcTo(oval, 90, 90);
        path.close();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        canvas.drawPath(path, paint);
    }
}