class Matrix;

class Transposed
{
public:
  Transposed(Matrix &matrix) : m_matrix(matrix) {}
  Matrix & obj (void) { return m_matrix; }
private:
  Matrix & m_matrix;
};

class MatrixMatrixMulTransPosed
{
public:
  MatrixMatrixMulTransPosed(Matrix &matrix, Transposed &trans) 
    : m_matrix(matrix), m_transposed(trans.obj()) {}
  Matrix & matrix (void) { return m_matrix; }
  Matrix & transposed (void) { return m_transposed; }
private:
  Matrix & m_matrix;
  Matrix & m_transposed;
};

class Matrix
{
  public:
    MatrixMatrixMulTransPosed operator* (Transposed &rhs)
    { 
      return MatrixMatrixMulTransPosed(*this, rhs); 
    }

    Matrix& operator= (MatrixMatrixMulTransPosed &mmtrans)
    {
      // Actual computation goes here and is stored in this.
      // using mmtrans.matrix() and mmtrans.transposed()
    }
};