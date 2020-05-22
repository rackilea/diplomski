myStak.push((input));
   String operator = myStak.peek();
    switch(operator.charAt(0))
    {
        case '+':
        int a = Integer.parseInt(myStak.pop());