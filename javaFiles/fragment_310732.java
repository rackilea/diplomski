//get the row sums
mtx.multiply(MatrixUtils.createRealMatrix(new double[][]{{1}, {1}}))
> Array2DRowRealMatrix{{3.0},{7.0},{11.0}}
//get the column sums
MatrixUtils.createRealMatrix(new double[][]{{1, 1, 1}}).multiply(mtx)
> Array2DRowRealMatrix{{9.0,12.0}}