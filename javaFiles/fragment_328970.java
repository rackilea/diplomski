public static Vec2 getDimensions( final PolygonShape shape ) {
    float minX = Float.MAX_VALUE;
    float maxX = Float.MIN_VALUE;
    float minY = Float.MAX_VALUE;
    float maxY = Float.MIN_VALUE;

    final int vertices = shape.getVertexCount();

    for( int i = 0; i < vertices; i++ ) {
      final Vec2 v = shape.getVertex( i );

      minX = (v.x < minX) ? v.x : minX;
      maxX = (v.x > maxX) ? v.x : maxX;
      minY = (v.y < minY) ? v.y : minY;
      maxY = (v.y > maxY) ? v.y : maxY;
    }

    return new Vec2( maxX - minX, maxY - minY );
  }