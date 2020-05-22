public PercolationStats(int N, int T) {
    t=T;
    N1 = N;
    sample_threshold[i] = new double[T]; // add this line
    int number_of_open=0;
    for(int i=0;i<T;i++) {
        B=new Percolation(N1);
        while(!B.percolates()) {
            double r1 = Math.random();
            int open_i = (int)(r1*N1);
            double r2 = Math.random();
            int open_j = (int)(r2*N1);
            B.open(open_i,open_j);
        }
        for(int k=0;k<N1;k++) {
        for(int j=0;j<N1;j++) {
            if(B.isOpen(k, j))
                number_of_open++;
        }
        sample_threshold[i] = (number_of_open*1.0)/N1;
        }

    }
}