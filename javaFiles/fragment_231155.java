for (int i = 1; i <= n; i++) {
        m[i-1][i-1] = 0;
    }

    for (int l = 2; l <= n; l++) {
        for (int i = 1; i <= n - l + 1; i++) {
            int j = i + l - 1;
            m[i-1][j-1] = 9999;
            for (int k = i; k <= j - 1; k++) {
                int q = m[i-1][k-1] + m[k][j-1] + p[i - 1] * p[k] * p[j];
                if (q < m[i-1][j-1]) {
                    m[i-1][j-1] = q;
                    s[i-1][j-2] = k;
                }
            }
        }
    }
    parenterizacao(s, 1, n);