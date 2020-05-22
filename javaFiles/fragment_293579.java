public static  int partition(int a[],int p,int q){
    int  m=a[p]; // not m[0], you want to partition m[p..q]!!!
    while ( p<q){
        while (p<q && a[p] <m){ // don't do p++ here!
            p++;
        }
        while (q>p && a[q]>m){ // don't do q-- here!
            q--;
        }
        int t=a[p];
        a[p]=a[q];
        a[q]=t;
    }
    return p; // no need to search!!!
}