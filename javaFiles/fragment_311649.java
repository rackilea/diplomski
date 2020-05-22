if (stack.size()==0){
    // message when the stack is empty: parenthesis not closed
     break;
 }
 char r = stack.peek();
 if (p == '}' || p == ')' || p == ']')
 {

    if (p == '}' && r == '{' || p == ')' && r == '(' || p == ']' && r == '['){
      stack.pop();
    System.out.print("Arithmetic Expression: has matched symbols.");
    }

             else {
    System.out.print("Arithmetic  Expression: has mismatched symbols.");

          } 


  }


}