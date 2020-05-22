public Matrix4f translate(Matrix4f matrix, Vec3 vector) {

    Matrix4f transform = new Matrix4f(new float[][] {
            new float[] { 1, 0, 0, vector.x },
            new float[] { 0, 1, 0, vector.y },
            new float[] { 0, 0, 1, vector.z },
            new float[] { 0, 0, 0, 1 },
    });

    return multiply(matrix, transform);
}

public Matrix4f multiply(Matrix4f matrixA, Matrix4f matrixB) {

    Matrix4f matrix = new Matrix4f(new float[][] {
            new float[] {
                    (matrixA.values[0] * matrixB.values[0]) + (matrixA.values[1] * matrixB.values[4]) + (matrixA.values[2] * matrixB.values[8]) + (matrixA.values[3] * matrixB.values[12]),
                    (matrixA.values[0] * matrixB.values[1]) + (matrixA.values[1] * matrixB.values[5]) + (matrixA.values[2] * matrixB.values[9]) + (matrixA.values[3] * matrixB.values[13]),
                    (matrixA.values[0] * matrixB.values[2]) + (matrixA.values[1] * matrixB.values[6]) + (matrixA.values[2] * matrixB.values[10]) + (matrixA.values[3] * matrixB.values[14]),
                    (matrixA.values[0] * matrixB.values[3]) + (matrixA.values[1] * matrixB.values[7]) + (matrixA.values[2] * matrixB.values[11]) + (matrixA.values[3] * matrixB.values[15])
            },
            new float[] {
                    (matrixA.values[4] * matrixB.values[0]) + (matrixA.values[5] * matrixB.values[4]) + (matrixA.values[6] * matrixB.values[8]) + (matrixA.values[7] * matrixB.values[12]),
                    (matrixA.values[4] * matrixB.values[1]) + (matrixA.values[5] * matrixB.values[5]) + (matrixA.values[6] * matrixB.values[9]) + (matrixA.values[7] * matrixB.values[13]),
                    (matrixA.values[4] * matrixB.values[2]) + (matrixA.values[5] * matrixB.values[6]) + (matrixA.values[6] * matrixB.values[10]) + (matrixA.values[7] * matrixB.values[14]),
                    (matrixA.values[4] * matrixB.values[3]) + (matrixA.values[5] * matrixB.values[7]) + (matrixA.values[6] * matrixB.values[11]) + (matrixA.values[7] * matrixB.values[15])
            },
            new float[] {
                    (matrixA.values[8] * matrixB.values[0]) + (matrixA.values[9] * matrixB.values[4]) + (matrixA.values[10] * matrixB.values[8]) + (matrixA.values[11] * matrixB.values[12]),
                    (matrixA.values[8] * matrixB.values[1]) + (matrixA.values[9] * matrixB.values[5]) + (matrixA.values[10] * matrixB.values[9]) + (matrixA.values[11] * matrixB.values[13]),
                    (matrixA.values[8] * matrixB.values[2]) + (matrixA.values[9] * matrixB.values[6]) + (matrixA.values[10] * matrixB.values[10]) + (matrixA.values[11] * matrixB.values[14]),
                    (matrixA.values[8] * matrixB.values[3]) + (matrixA.values[9] * matrixB.values[7]) + (matrixA.values[10] * matrixB.values[11]) + (matrixA.values[11] * matrixB.values[15])
            },
            new float[] {
                    (matrixA.values[12] * matrixB.values[0]) + (matrixA.values[13] * matrixB.values[4]) + (matrixA.values[14] * matrixB.values[8]) + (matrixA.values[15] * matrixB.values[12]),
                    (matrixA.values[12] * matrixB.values[1]) + (matrixA.values[13] * matrixB.values[5]) + (matrixA.values[14] * matrixB.values[9]) + (matrixA.values[15] * matrixB.values[13]),
                    (matrixA.values[12] * matrixB.values[2]) + (matrixA.values[13] * matrixB.values[6]) + (matrixA.values[14] * matrixB.values[10]) + (matrixA.values[15] * matrixB.values[14]),
                    (matrixA.values[12] * matrixB.values[3]) + (matrixA.values[13] * matrixB.values[7]) + (matrixA.values[14] * matrixB.values[11]) + (matrixA.values[15] * matrixB.values[15])
            }
    });

    return matrix;
}