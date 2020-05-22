long[][] matrix_create(int n)
{
    return new long[n][n];
}

void matrix_multiply(int n, long m, long[][] c, long[][] a, long[][] b)
{
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            long s = 0;
            for (int k = 0; k < n; k++)
                s = mod(m, s + mod(m, a[i][k]*b[k][j]));
            c[i][j] = s;
        }
    }
}

void matrix_pow(int n, long m, long p, long[][] y, long[][] x)
{
    // swap matrices
    long[][] a = matrix_create(n);
    long[][] b = matrix_create(n);
    long[][] c = matrix_create(n);

    // initialize accumulator to identity
    for (int i = 0; i < n; i++)
        a[i][i] = 1;

    // initialize base to original matrix
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            b[i][j] = x[i][j];

    // exponentiation by squaring
    // there are better algorithms, but this is the easiest to implement
    // and is still O(log n)
    long[][] t = null;
    for (long s = p; s > 0; s /= 2) {
        if (s % 2 == 1) {
            matrix_multiply(n, m, c, a, b);
            t = c; c = a; a = t;
        }
        matrix_multiply(n, m, c, b, b);
        t = c; c = b; b = t;
    }

    // write to output
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            y[i][j] = a[i][j];
}