public static void main(String[] args) {
    int z;
        int [] a = new int[5];
    a[0]=4;
    a[1]=8;
    a[2]=5;
    a[3]=1;
    a[4]=3;
    for(;;){
        z=0;
    for(int i=1;i<a.length;i++){

    if(a[i-1]>a[i]){
        int tmp = a[i-1];
        a[i-1]=a[i];
        a[i]=tmp;
        z++;

    }

    }
    if(z==0){
        break;
    }

    }
    for(int i=0;i<a.length;i++)
    {
        System.out.println(a[i]);
    }
}