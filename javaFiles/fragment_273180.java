int precedence[] = { 2, 2, 3, 3, 1, 4, 4 };  // I think this is correct

int index = "+-*/=()".indexOf(token); 
if (index > -1) {

    // if you get into this block then token is one of the operators.
    // and its relative precedence is precedence[index]

}