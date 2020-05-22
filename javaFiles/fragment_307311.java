if(a[0]>a[1]){
        min=1;
        nmin=0;
    }
    if(a[nmin]>a[tmin]){
        int tmp =nmin;
        nmin=tmin;
        tmin=tmp;
    }
    if(a[min]>a[nmin]){
        int tmp =min;
        min=nmin;
        nmin=tmp;
    }