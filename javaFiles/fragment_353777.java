Path outline = region.getBoundaryPath();
Path newpath = new Path();
Matrix matrix = new Matrix();
matrix.setScale(1, 1, 0, 0);
outline.transform(matrix,newpath);
canvas.drawPath(newpath, paint);