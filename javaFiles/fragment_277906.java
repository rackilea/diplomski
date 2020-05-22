Polygon shape = new Polygon();
shape.addPoint(...);
....
Rectangle bounds = shape.getBounds();
AffineTransform transform = new AffineTransform();
transform.rotate(Math.toRadians(angle), bounds.width / 2, bounds.height / 2);

Path2D path = (shape instanceof Path2D) ? (Path2D)shape : new GeneralPath(shape);
Shape rotated = path.createTransformedShape( transform );
System.out.println(rotated.getBounds());