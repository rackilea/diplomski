DSAQueue<Object> postfixQueue = new DSAQueue<Object>();

private double evaluatePostfix (Queue<Object> postfixQueue)
{

  // Here you define an empty list
  DSAStack<Double> operandStack = new Stack<Double>();

  while (postfixQueue.isEmpty() == false)
  {
    if (postfixQueue.peek() instanceof Double)
    {
      operandStack.push((Double)(postfixQueue.dequeue()));
    }
    else
    {
      // If the first item in postfixQueue was not a Double, you're now
      // pop-ing from an empty stack
      double num1 = ((double)operandStack.pop());
      double num2 = ((double)operandStack.pop());
      char operator = ((char)postfixQueue.dequeue());
      double result = executeOperation (operator, num1, num2);
      operandStack.push(result);
    }
  }
  double solution = operandStack.top();
  return solution;
}