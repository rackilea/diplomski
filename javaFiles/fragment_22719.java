private static final Function<Point2D, Number> DEFAULT_FUNCTION = 
    p -> Math.sin(p.magnitude()) / p.magnitude();

private static final double DEFAULT_X_RANGE = 10; // -5 +5
private static final double DEFAULT_Y_RANGE = 10; // -5 +5
private static final int DEFAULT_X_DIVISIONS = 64;
private static final int DEFAULT_Y_DIVISIONS = 64;
private static final double DEFAULT_FUNCTION_SCALE = 1.0D;