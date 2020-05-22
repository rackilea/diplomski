package linearalgebra;

import Jama.LUDecomposition;
import Jama.Matrix;

public class JamaDemo
{
    public static void main(String[] args)
    {
        double [][] values = {{1, 1, 2}, {2, 4, -3}, {3, 6, -5}};  // each array is a row in the matrix
        double [] rhs = { 9, 1, 0 }; // rhs vector
        double [] answer = { 1, 2, 3 }; // this is the answer that you should get.

        Matrix a = new Matrix(values);
        a.print(10, 2);
        LUDecomposition luDecomposition = new LUDecomposition(a);
        luDecomposition.getL().print(10, 2); // lower matrix
        luDecomposition.getU().print(10, 2); // upper matrix

        Matrix b = new Matrix(rhs, rhs.length);
        Matrix x = luDecomposition.solve(b); // solve Ax = b for the unknown vector x
        x.print(10, 2); // print the solution
        Matrix residual = a.times(x).minus(b); // calculate the residual error
        double rnorm = residual.normInf(); // get the max error (yes, it's very small)
        System.out.println("residual: " + rnorm);
    }
}