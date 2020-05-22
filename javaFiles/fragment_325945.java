int number =22;
int bits[]= new int[8];
for(int i=0;i<=7;i++){
    if(number>0){
        bits[7-i]=number%2;
        number/=2;
    }
    else{
        bits[7-i]=0;
    }
}
for(int i=0;i<=7;i++){
    System.out.print(bits[i]);
}