static void floyd_warshallSingle()
    {
        int i, j, k;
        for (k = 0; k < n; ++k)
        {
            var distk = dist[k];
            for (i = 0; i < n; ++i)
            {
                var disti = dist[i];
                for (j = 0; j < n; ++j)
                    if ((i != j) && (disti[k] * distk[j] != 0))
                        if ((disti[j] == 0) || disti[k] + distk[j] < disti[j])
                            disti[j] = disti[k] + distk[j];
            }
        }
    }