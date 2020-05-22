boolean flip = false;
int num1, num2, op, result;
String operation;
Random r = new Random();

num1 = r.nextInt(8)+2;
num2 = r.nextInt(8)+2;
op = r.nextInt(4);    

switch(op) {
case 0:
    // Always be positive.
    operation = "+";
    result = num1+num2
    break;
case 1:
    // Could be negative if num2 is larger than num1. Simply flip the numbers.
    flip = num1 < num2;
    operation = "-";
    result = flip ? num2-num1 : num1-num2;
    break;
case 2:
    // Always be positive.
    operation = "*";
    result = num1*num2;
    break;
case 3:
    // Always be positive.
    operation = "/";
    result = num1/num2;
    break;
}