DrawableShape drawableShape = null;

if (value.equals("Rectangle"))
    drawableShape = new DrawableRectangle(….);
else
    drawableShape = new DrawableOval(...);

drawing.setDrawableShape( drawableShape );