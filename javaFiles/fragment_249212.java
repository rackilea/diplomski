int x = 0, y = 0;
x--;

int yOperand1 = x++;
int yOperand2 = ++x;
y = yOperand1 + yOperand2;

int resultOperand1 = x;
int resultOperand2 = y;
int resultOperand3 = ++x;
int result = resultOperand1 + resultOperand2 + resultOperand3;
System.out.println(result);