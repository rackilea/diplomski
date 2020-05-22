int width = canvas.getWidth();
int height = canvas.getHeight();
Rect childRect = this.getChildRect();

Paint outerPaint = new Paint();
outerPaint.setColor(Color.LTGRAY);
outerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
outerPaint.setAntiAlias(true);

Paint innerPaint = new Paint();
innerPaint.setColor(Color.TRANSPARENT);
innerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
innerPaint.setAntiAlias(true);

canvas.drawRect(0.0F, 0.0F, width, height, outerPaint);
canvas.drawRoundRect(new RectF(childRect.left, childRect.top, childRect.right, childRect.bottom), 8F, 8F, innerPaint);