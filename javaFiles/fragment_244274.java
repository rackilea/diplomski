private Quaternion setFromAxes(float xx, float xy, float xz, float yx, float yy, float yz, float zx, float zy, float zz){

    //normalise axis
    Vector3 xAxis = new Vector3(xx, xy, xz).nor();
    Vector3 yAxis = new Vector3(yx, yy, yz).nor();
    Vector3 zAxis = new Vector3(zx, zy, zz).nor();

    xx = xAxis.x;
    xy = xAxis.y;
    xz = xAxis.z;

    yx = yAxis.x;
    yy = yAxis.y;
    yz = yAxis.z;

    zx = zAxis.x;
    zy = zAxis.y;
    zz = zAxis.z;

    // the trace is the sum of the diagonal elements; see
    // http://mathworld.wolfram.com/MatrixTrace.html
    final float m00 = xx, m01 = xy, m02 = xz;
    final float m10 = yx, m11 = yy, m12 = yz;
    final float m20 = zx, m21 = zy, m22 = zz;
    final float t = m00 + m11 + m22;

    // we protect the division by s by ensuring that s>=1
    double x, y, z, w;
    if (t >= 0) { // |w| >= .5
        double s = Math.sqrt(t + 1); // |s|>=1 ...
        w = 0.5 * s;
        s = 0.5 / s; // so this division isn't bad
        x = (m21 - m12) * s;
        y = (m02 - m20) * s;
        z = (m10 - m01) * s;
    } else if ((m00 > m11) && (m00 > m22)) {
        double s = Math.sqrt(1.0 + m00 - m11 - m22); // |s|>=1
        x = s * 0.5; // |x| >= .5
        s = 0.5 / s;
        y = (m10 + m01) * s;
        z = (m02 + m20) * s;
        w = (m21 - m12) * s;
    } else if (m11 > m22) {
        double s = Math.sqrt(1.0 + m11 - m00 - m22); // |s|>=1
        y = s * 0.5; // |y| >= .5
        s = 0.5 / s;
        x = (m10 + m01) * s;
        z = (m21 + m12) * s;
        w = (m02 - m20) * s;
    } else {
        double s = Math.sqrt(1.0 + m22 - m00 - m11); // |s|>=1
        z = s * 0.5; // |z| >= .5
        s = 0.5 / s;
        x = (m02 + m20) * s;
        y = (m21 + m12) * s;
        w = (m10 - m01) * s;
    }

    return new Quaternion((float)x, (float)y, (float)z, (float)w);

}