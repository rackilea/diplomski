static int Lcm(int[] newArray){
    int multi =newArray[0];
    int gcd = 0;
    for(int i=1; i< newArray.length; i++){
        gcd = getGcd(multi, newArray[i]);
        if(gcd == 1) {
            multi = multi * newArray[i];
        }else {
            multi = multi * newArray[i] / gcd;
        }
    }
    return multi;
}