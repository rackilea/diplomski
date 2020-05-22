long recurrence_matrix(
    long a, long b, long c,
    long p, long q, long r,
    long n, long m
) {
    if (n == 0) return p;
    if (n == 1) return q;
    if (n == 2) return r;

    // original recurrence matrix
    long[][] mat = matrix_create(7);
    mat[0][0] = a; mat[0][1] = b; mat[0][2] = c; mat[0][3] = 1;
    mat[1][0] = 1; mat[2][1] = 1;
    mat[3][3] = 3; mat[3][4] = -3; mat[3][5] = 1; mat[3][6] = 6;
    mat[4][3] = 1; mat[5][4] = 1;
    mat[6][6] = 1;

    // exponentiate
    long[][] res = matrix_create(7);
    matrix_pow(7, m, n - 2, res, mat);

    // multiply the first row with the initial vector
    return mod(m, mod(m, res[0][6])
        + mod(m, res[0][0]*r)  + mod(m, res[0][1]*q)  + mod(m, res[0][2]*p)
        + mod(m, res[0][3]*36) + mod(m, res[0][4]*12) + mod(m, res[0][5]*2)
    );
}