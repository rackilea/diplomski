Paint paint = new Paint();
paint.setColor(Color.BLACK);
paint.setStrokeWidth(3);
canvas.drawRect(30, 30, 80, 80, paint);
paint.setStrokeWidth(0);
paint.setColor(Color.CYAN);
canvas.drawRect(33, 60, 77, 77, paint );
paint.setColor(Color.YELLOW);
canvas.drawRect(33, 33, 77, 60, paint );