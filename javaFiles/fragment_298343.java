protected static void drawAt(Canvas canvas, Drawable drawable, int x, int y, boolean shadow)
  {
      // .... Do Stuff ....

      canvas.save();
      canvas.translate(x, y);

      // .... Do Stuff ....

      drawable.draw(canvas);

      // .... Do Stuff ....

      canvas.restore();
  }