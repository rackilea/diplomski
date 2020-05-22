import breeze.linalg.operators.{BinaryOp, OpMulScalar}

object CSCMatrixExtraOps {
  abstract class CSCMatrixCanMulM_M[@specialized (Int, Float, Long, Double) A]
    extends BinaryOp[CSCMatrix[A], CSCMatrix[A], OpMulScalar, CSCMatrix[A]] {

    protected def times(a: A, b: A): A

    protected def zeros  (rows: Int, cols: Int): CSCMatrix[A]
    protected def builder(rows: Int, cols: Int, sz: Int): CSCMatrix.Builder[A]

    final def apply(a: CSCMatrix[A], b: CSCMatrix[A]): CSCMatrix[A] = {
      val rows  = a.rows
      val cols  = a.cols
      require(rows == b.rows, "Matrices must have same number of rows!")
      require(cols == b.cols, "Matrices must have same number of cols!")

      if (cols == 0) return zeros(rows, cols)