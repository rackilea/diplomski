protected double curvatureAtStart(Vector3 p0, Vector3 p1, Vector3 p2, Vector3 p3) {
    double dx1 = p1.x - p0.x;
    double dy1 = p1.y - p0.y;
    double dz1 = p1.z - p0.z;

    double A = dx1 * dx1 + dy1 * dy1 + dz1 * dz1;

    double dx2 = p0.x - 2*p1.x + p2.x;
    double dy2 = p0.y - 2*p1.y + p2.y;
    double dz2 = p0.z - 2*p1.z + p2.z;

    double B = dx1 * dx2 + dy1 * dy2 + dz1 * dz2;

    double Rx = (dx2 - dx1*B/A)/A*2/3;
    double Ry = (dy2 - dy1*B/A)/A*2/3;
    double Rz = (dz2 - dz1*B/A)/A*2/3;

    return Math.sqrt(Rx * Rx + Ry * Ry + Rz * Rz);
}