double a;  //compiler: "okay, a is going to refer to a double" 
int b;  //compiler: "okay, b is going to refer to an int" 

//...THEN: 

a = userNum;  //compiler: "cool, a refers to THAT double"
b = userNum2;   //compiler: "cool, b refers THAT int"