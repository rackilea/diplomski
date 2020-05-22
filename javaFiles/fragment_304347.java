for(int i=0;i<n;i++){
    int min=i;
    for(int j=i+1;j<n;j++){
        if(!isSmaller(a[min],a[j]))
            min=j;
            exch(a,i,min); // HERE
    }
}