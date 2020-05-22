double[] untransformedPoints = {
    resized.getVertexA().getX(), resized.getVertexA().getY(),
    resized.getVertexB().getX(), resized.getVertexB().getY(),
    resized.getVertexC().getX(), resized.getVertexC().getY(),
    resized.getVertexA().getX(), resized.getVertexA().getY()
};

double[] transformedPoints = new double[untransformedPoints.length];

AffineTransform rotation = AffineTransform.getRotateInstance(
    Math.toRadians(alpha), start.getX(), start.getY());

rotation.transform(untransformedPoints, 0, transformedPoints, 0,
    untransformedPoints.length / 2);

Tuple vertexC = new Tuple(transformedPoints[4], transformedPoints[5]);