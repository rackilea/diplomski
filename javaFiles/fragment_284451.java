double doubleVal = 0.33333;
double negligibleRatio = 0.01;

for(int i=1;;i++){
    double tem = doubleVal/(1D/i);
    if(Math.abs(tem-Math.round(tem))<negligibleRatio){
        System.out.println(Math.round(tem)+"/"+i);
        break;
    }
}