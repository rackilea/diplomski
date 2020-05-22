public static boolean testTriangleAABB( Triangle triangle, 
        Vector3d origin, double size ) {
    setTriangleNormal( triangle.getNormal( true ) );
    Vector3d[] aabbVertices = calculateAABBVertices( origin, size );

    // Triangle Normal axis test, false = No Collision.
    if( !testTriangleNormal( triangle, aabbVertices ) ) {
        return false;
    }

    // Triangle Edge Normals axis test, false = No Collision.
    if( !testTriangleEdgeNormals( triangle, aabbVertices ) ) {
        return false;
    }

    // Axis-Aligned Bounding Box X, Y, Z axis test, false = No Collision.
    if( !testAABBAxis( triangle, aabbVertices ) ) {
        return false;
    }     

    // if we get here then we know that every axis had overlap on it
    // so we can guarantee an intersection
    return true;
}

...

private static boolean testTriangleEdgeNormals( Triangle triangle, Vector3d[] aabbVertices ) {
    Vector3d edge = new Vector3d();
    Vector3d edgeNormal = new Vector3d();

    // loop over the triangle edge normals
    Vector3d[] points = triangle.getPoints();
    for( int i = 0; i < points.length; i++ ) {
        int iOverflow = i + 1 == points.length ? 0 : i + 1;
        edge.sub( points[ i ], points[ iOverflow ] );
        edge.normalize();
        edgeNormal.cross( getTriangleNormal(), edge );

        // project both shapes onto the axis
        projectionAABB = project2D1D( aabbVertices, edgeNormal );
        projectionTriangle = project2D1D( triangle.getPoints(), edgeNormal );
        // do the projections overlap?
        if ( !projectionAABB.hasOverlap( projectionTriangle ) ) {
            // then we can guarantee that the shapes do not overlap
            return false;
        }
    }
    return true;
}