double[][] testSquare = {{0.69314718}, {1.09861229}, {1.38629436}, {1.60943791}, {1.79175947}, {1.94591015}};
RealMatrix matrix = MatrixUtils.createRealMatrix(testSquare);
SingularValueDecomposition svd = new SingularValueDecomposition(matrix);
DecompositionSolver ds=svd.getSolver();
double[] b = {0.0, 0.20273255, 0.5815754, 0.7520387, 0.96885669, 1.09861229};
ds.solve(b)[0];