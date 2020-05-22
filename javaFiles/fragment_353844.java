protected void subdivide(
        Vector3 p0, Vector3 p1, Vector3 p2, Vector3 p3,
        Vector3 q0, Vector3 q1, Vector3 q2, Vector3 q3,
        Vector3 q4, Vector3 q5, Vector3 q6) {

    q0.x = p0.x; q0.y = p0.y; q0.z = p0.z;
    q6.x = p3.x; q6.y = p3.y; q6.z = p3.z;

    q1.x = (p0.x + p1.x) * 0.5;
    q1.y = (p0.y + p1.y) * 0.5;
    q1.z = (p0.z + p1.z) * 0.5;

    q5.x = (p2.x + p3.x) * 0.5;
    q5.y = (p2.y + p3.y) * 0.5;
    q5.z = (p2.z + p3.z) * 0.5;

    double x3 = (p1.x + p2.x) * 0.5;
    double y3 = (p1.y + p2.y) * 0.5;
    double z3 = (p1.z + p2.z) * 0.5;

    q2.x = (q1.x + x3) * 0.5;
    q2.y = (q1.y + y3) * 0.5;
    q2.z = (q1.z + z3) * 0.5;

    q4.x = (x3 + q1.x) * 0.5;
    q4.y = (y3 + q1.y) * 0.5;
    q4.z = (z3 + q1.z) * 0.5;

    q3.x = (q2.x + q4.x) * 0.5;
    q3.y = (q2.y + q4.y) * 0.5;
    q3.z = (q2.z + q4.z) * 0.5;
}