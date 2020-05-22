public static void main(String[] args) {
    // the input matrix
    double[][] matrix = {
        {1.0, 1.0},
        {1.0, -1.0}
    };

    // compute the basis
    double[] basis = getBasis(matrix);

    System.out.println("Basis: (" + basis[0] + ", " + basis[1] + ")");
}

public double[] getBasis(double[][] matrix){

    double a = matrix[0][0];
    double b = matrix[0][1];
    double c = matrix[1][0];
    double d = matrix[1][1];

    double eigenvalue1 = ((a+d) + Math.sqrt( Math.pow(a-d,2) + 4*b*c))/2;
    double eigenvalue2 = ((a+d) - Math.sqrt( Math.pow(a-d,2) + 4*b*c))/2;

    // store the basis in a 2 element array
    double[] basis = new double[2];

    for (double y = -1000; y <= 1000; y++) {
        for (double x = -1000; x <= 1000; x++) {
            if (((a-eigenvalue1)*x + b*y == 0) && (c*x + (d-eigenvalue1)*y == 0)) {
                System.out.println("Eigenvector1: (" + x + "," + y + ")");
                basis[0] = eigenvalue1;
            }
        }
    }   

    for (double y = -10; y <= 10; y++) {
        for (double x = -10; x <= 10; x++) {
            if (((a-eigenvalue2)*x + b*y == 0) && (c*x + (d-eigenvalue2)*y == 0)) {
                System.out.println("Eigenvector2: (" + x + "," + y + ")");
                basis[1] = eigenvalue2;
            }
        }
    }

    return basis;
}