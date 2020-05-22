public static Matrix exponential(Matrix A, int nSteps){

    Matrix seriesTerm = identityMatrix(A.getM());
    Matrix sum = identityMatrix(A.getM());

    for(int i = 1; i <= nSteps; i++){
        seriesTerm = Matrix.scaleMatrix(Matrix.multiply(seriesTerm,A),1.0/i);
        sum = Matrix.addMatrix(seriesTerm, sum);
    }
    return sum;
}