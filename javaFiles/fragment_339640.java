int remainder=0;
    Stack<Integer> stack = new Stack<Integer>();

    while (digit != 0) {
                count += 1;
                remainder= digit % 10;
                digit=digit/10;
                stack.push(remainder);

            }

   while(!stack.isEmpty())
      System.out.println(stack.pop());