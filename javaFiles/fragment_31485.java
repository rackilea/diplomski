// in a scope higher than your action listener
boolean flag = false;

// code...

// action listener of your button:
if(flag){
    functionA();
} else {
    functionB();
}
flag = !flag;