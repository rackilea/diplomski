public static BigInteger[][] MultiplyMatrixB(BigInteger[][] mat1, BigInteger[][] mat2) {

    return new BigInteger[][]{
            {(mat1[0][0].multiply(mat2[0][0])).add((mat1[0][1].multiply(mat2[1][0]))),
                    (mat1[0][0].multiply(mat2[0][1])).add((mat1[0][1].multiply(mat2[1][1])))
            },
            {
                    (mat1[1][0].multiply(mat2[0][0])).add((mat1[1][1].multiply(mat2[1][0]))),
                    (mat1[1][0].multiply(mat2[0][1])).add((mat1[1][1].multiply(mat2[1][1])))
            }
    };
}