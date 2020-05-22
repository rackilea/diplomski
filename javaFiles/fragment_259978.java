public Stack<Integer> sum(Stack<Integer> leadingStack, Stack<Integer> secondStack) {
  int carry = 0;
  Stack<Integer> resultStack = new Stack<Integer>();
  while (leadingStack.isEmpty() == false && secondStack.isEmpty() == false) {
    int dig1 = leadingStack.pop();
    int dig2 = secondStack.pop();
    int result = dig1 + dig2 + carry;
    int resultDig = result % 10;
    carry = result / 10;
    resultStack.push(resultDig);
  }

  Stack<Integer> leftStack = leadingStack.isEmpty() ? secondStack : leadingStack;
  while (leftStack.isEmpty() == false) {
    int dig = leftStack.pop();
    if (carry > 0) {
        dig += carry;
        carry = 0;
    }
    resultStack.push(dig);
  }

  if (carry > 0) resultStack.push(carry);
  return reverse(resultStack);
}

public Stack<Integer> sub(Stack<Integer> leadingStack, Stack<Integer> secondStack) {
  boolean borrow = false;
  Stack<Integer> resultStack = new Stack<Integer>();

  if (leadingStack.size() < secondStack.size()) {
    // Handle negative number
  }
  while (leadingStack.isEmpty() == false && secondStack.isEmpty() == false) {
    int dig1 = leadingStack.pop();
    int dig2 = secondStack.pop();
    if (borrow) {
        dig1 -= 1;
        borrow = false;
    }
    if (dig1 < dig2) {
        dig1 += 10;
        resultStack.push(dig1 - dig2);
        borrow = true;
    }
    else {
        resultStack.push(dig1 - dig2);
    }
  } 

  Stack<Integer> leftStack = leadingStack.isEmpty() ? secondStack : leadingStack;
  while (leftStack.isEmpty() == false) {
    int dig = leftStack.pop();
    if (borrow) {
      dig -= 1; 
      borrow = false;
    }
    resultStack.push(dig);
  }

  if (borrow) {
    // Handle negative number
  }
  return reverse(resultStack);
}

private Stack<Integer> reverse(Stack<Integer> inStack) {
  Stack<Integer> outStack = new Stack<>();
   while (inStack.isEmpty() == false) outStack.push(inStack.pop());
   return outStack;
}