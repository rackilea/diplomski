import no.uib.cipr.matrix.DenseMatrix;

// ...

breeze.linalg.DenseMatrix[Double] Ubreeze = U.toBreeze();
new DenseMatrix(Ubreeze.cols(), Ubreeze.rows(), Ubreeze.data());