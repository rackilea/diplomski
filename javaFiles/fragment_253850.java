void fi() {
    int z,i,inc[k];

    for(i=0 ; i<k ; i++) {
      a[i] = 0;     // initialize our array if needed
      inc[i] = 1;   // all digits are in +1 mode
    }
    int p = k-1;    // p, position: start from last digit (right)

    while(p >= 0) {
        if (p == k-1) {
            for(z=0 ; z<k ; z++) printf("%d", a[z]);
            printf("\n");
        }
        if (inc[p]<0 && a[p]>0 || inc[p]>0 && a[p]<N-1) {
          a[p] += inc[p];
          p = k-1;
        }
        else {
          inc[p] = -inc[p];
          p--;
        }
    }
}