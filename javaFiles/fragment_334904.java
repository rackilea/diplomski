JtsSpatialContextFactory jtsSpatialContextFactory = new JtsSpatialContextFactory();
JtsSpatialContext jtsSpatialContext = jtsSpatialContextFactory.newSpatialContext();
JtsShapeFactory jtsShapeFactory = jtsSpatialContext.getShapeFactory();
ShapeFactory.PolygonBuilder polygonBuilder = jtsShapeFactory.polygon();
// note due to it being a builder one needs to chain the points.
Shape shape1 = polygonBuilder.pointXY(4, 0).pointXY(3, 3).pointXY(1, 4).pointXY(0, 0).pointXY(4, 0).build();