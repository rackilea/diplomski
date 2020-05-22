@Provides List<ShapeBuilder> provideShapeBuilders(
    CircleBuilder circleBuilder,
    SquareBuilder squareBuilder,
    TriangleBuilder triangleBuilder,
    Provider<TrapezoidBuilder> trapezoidBuilderProvider) {
  return new ArrayList<ShapeBuilder>(
      circleBuilder,
      squareBuilder,
      triangleBuilder,
      trapezoidBuilderProvider.get(),
      trapezoidBuilderProvider.get());
}