public double calcGreater(double a, double b){ // expected return type double 
    boolean greater = false;
    if (a > b){
        greater = true;
    }
    if (b > a){
        greater = false;
    }
    return greater;  // you are returning boolean
}