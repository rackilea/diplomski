while (inputStack.isEmpty() != true)
    {      
       //System.out.println(inputStack.pop());

        if (isNumber(inputToken))
        {
            number = Integer.parseInt(inputToken);
            evaluationStack.push(number);