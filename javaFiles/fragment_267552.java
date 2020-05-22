int [][]mat = { {1,2,3},
                {4,5,6},
                {7,8,9},
};

int N=3;

for (int s=N-1; s>-N; --s) {
    int iMin = s>0 ? s : 0;
    int iMax = s>0 ? N : N+s;
    for (int i=iMin; i<iMax; ++i) {
        System.out.print(mat[i-s][i] + " ");
    }
}
System.out.println();