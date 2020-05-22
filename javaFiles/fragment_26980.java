// new matrix where each row is the vector you want to add, i.e., aVector
DoubleMatrix2D otherMatrix = DoubleFactory2D.sparse.make(aVector.toArray(), n);
DoubleDoubleFunction plus = new DoubleDoubleFunction() {
    public double apply(double a, double b) { return a+b; }
};
aMatrix.assign(otherMatrix, plus);