//or whatever numbers you want here
int myLow = -10;
int myHigh = 10; 

public int randBetween(int low, int high){
    return (int) Math.round(Math.random() * (high - low)) + low;
}

public String makeProblem(AtomicLong answer){
    int a = randBetween(myLow, myHigh);
    int b = randBetween(myLow, myHigh);
    double result;
    char operator;
    switch(randBetween(1,4)){
        case 1: 
            operator = '+';
            result = a + b;
            break;
        case 2: 
            operator = '-';
            result = a - b;
            break;
        case 3: 
            operator = '*';
            result = a * b;
            break;
        case 4: 
            operator = '/';
            result = (double) a / b;
            break;
        default:
            operator = '\0';
            result = Double.NaN;
    }
    answer.set(Double.doubleToLongBits(result));
    return String.format("%d %c %d = ?",a,operator,b);
} 

public void yourFunction(){

    //whatever you need to do before

    AtomicLong outVariable = new AtomicLong();
    String question = makeProblem(outVariable);
    double answer = Double.longBitsToDouble(outVariable.get());

    //whatever you need to do after

}