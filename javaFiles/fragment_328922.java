int myFactorial(int C) {

    int n = Integer.parseInt(objectsChooseField.getText());
    int r = Integer.parseInt(chooseFromField.getText());

    if (C == 1){
       return 1; 
    }
    return (C*(myFactorial(n!/(r!(n-r)))));
    //C(n,r) = n!/(r!(n-r));    
}