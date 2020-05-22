Multibinder<ShapeBuilder> shapeBinder =
    Multibinder.newSetBinder(binder(), ShapeBuilder.class);
shapeBinder.addBinding().to(CircleBuilder.class);
shapeBinder.addBinding().to(TriangleBuilder.class);
shapeBinder.addBinding().to(SquareBuilder.class);

// Now you can inject Set<ShapeBuilder>.