int a[20] = {0}; // Put here the right size instead of 20, or use #define...
int N,k;

void f(int i) {
    int inc = a[i] ? -1:1;
    int end = a[i] ? 0:N-1;
    int j;

    for(j=a[i] ; inc<0 && j>=end || inc>0 && j<=end ; j+=inc) {
        a[i] = j;
        if (i < k-1) f(i+1);
        else {
            int z;
            for(z=0 ; z<k ; z++) printf("%d", a[z]);
            printf("\n");
        }
    }
}