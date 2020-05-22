for(int i=0; i!=32; i++){
    Log.i("loop vars", String.valueOf(i)+" "+String.valueOf(j)+" "+String.valueOf(z));
    2dArr[z][j] = arr[i];
    j++;
    z++;
    if(j==4){j=0;}
    if(z==8){z=0;}
}