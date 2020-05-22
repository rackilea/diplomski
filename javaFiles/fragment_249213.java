int x = 0, y = 0;           //x: 0   y: 0
x--;                        //x: -1  y: 0

int yOperand1 = x++;        //x: 0   y: 0  yOperand1: -1
int yOperand2 = ++x;        //x: 1   y: 0  yOperand1: -1  yOperand2: 1
y = yOperand1 + yOperand2;  //x: 1   y: 0

int resultOperand1 = x;     //x: 1   y: 0  resultOperand1: 1
int resultOperand2 = y;     //x: 1   resultOperand1: 1  resultOperand2: 0
int resultOperand3 = ++x;   //x: 2   resultOperand1: 1  resultOperand2: 0  resultOperand3: 2
int result = resultOperand1 + resultOperand2 + resultOperand3; //result: 3
System.out.println(result);