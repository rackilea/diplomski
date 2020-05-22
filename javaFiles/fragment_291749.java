private double zValueOfPoint(Triangle triangle, Point2D rayOrigin) 
{
    Vector3D surfaceNormal = getNormal(triangle);
    double A = surfaceNormal.x;
    double B = surfaceNormal.y;
    double C = surfaceNormal.z;
    double dzdx = -A / C;
    double dzdy = -B / C;
    double rayZ = triangle.getV1().z * modelViewer.getModelScale() + dzdx * (rayOrigin.x - triangle.getV1().projectPoint(modelViewer).x) + dzdy * (rayOrigin.y - triangle.getV1().projectPoint(modelViewer).y);
    return rayZ;
}