implicit object CSCMatrixCanMulM_M_Int extends CSCMatrixCanMulM_M[Int] {
    protected def times(a: Int, b: Int) = a * b
    protected def zeros(rows: Int, cols: Int) = CSCMatrix.zeros(rows, cols)
    protected def builder(rows: Int, cols: Int, sz: Int) = 
      new CSCMatrix.Builder(rows, cols, sz)
  }

  implicit object CSCMatrixCanMulM_M_Double extends CSCMatrixCanMulM_M[Double] {
    protected def times(a: Double, b: Double) = a * b
    protected def zeros(rows: Int, cols: Int) = CSCMatrix.zeros(rows, cols)
    protected def builder(rows: Int, cols: Int, sz: Int) = 
      new CSCMatrix.Builder(rows, cols, sz)
  }
}