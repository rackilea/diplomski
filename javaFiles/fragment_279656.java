public class CGMatrix {

public CGMatrix() {
}

public static float[][] identity() {
    return new float[][]{{1.0f, 0, 0, 0}, 
            {0, 1.0f, 0, 0},
            {0, 0, 1.0f, 0},
            {0, 0, 0, 1.0f}};
}

public static float[][] rotateX(float angle) {
    double r = angle * (Math.PI / 180);
    float s = (float)Math.sin(r);
    float c = (float)Math.cos(r);
    return new float[][] {{1, 0, 0, 0},
                        {0, c, s, 0},
                        {0, -s, c, 0},
                        {0, 0, 0, 1}};
}

public static float[][] rotateY(float angle) {
    double r = angle * (Math.PI / 180);
    float s = (float)Math.sin(r);
    float c = (float)Math.cos(r);
    return new float[][] {{c, 0, s, 0},
                        {0, 1, 0, 0},
                        {-s, 0, c, 0},
                        {0, 0, 0, 1}};
}

public static float[][] rotateZ(float angle) {
    double r = angle * (Math.PI / 180);
    float s = (float)Math.sin(r);
    float c = (float)Math.cos(r);
    return new float[][] {{c, s, 0, 0},
                        {-s, c, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 1}};
}

public static float[][] scale(float sx, float sy, float sz) {
    float[][] m = identity();
    m[0][0] *= sx;
    m[1][1] *= sy;
    m[2][2] *= sz;
    return m;
}

public static float[][] translate(float tx, float ty, float tz) {
    float[][] m = identity();
    m[3][0] = tx;
    m[3][1] = ty;
    m[3][2] = tz;
    return m;
}

public static float[][] multiply(float [][] a, float[][] b) {
    float[][] m = identity();
    for(int j = 0; j < 4; ++j){
        for(int i = 0; i < 4; ++i) {
            m[i][j] = 0;
            for(int k = 0; k < 4; ++k) {
                m[i][j] += a[i][k]*b[k][j];
            }
        }
    }
    return m;
}

public static FloatBuffer buffer(float[][] m) {
    float[] n = new float[16];
    int k = 0;
    for(int j = 0; j < 4; ++j) {
        for(int i = 0; i < 4; ++i) {
            n[k] = m[j][i];
            k++;
        }
    }
    return FloatBuffer.wrap(n);

}

}