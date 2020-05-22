public void convert(String s) {
    String pf = new String();
    int i=0, check=0;
    Stack<Character> s1 = new Stack<>();


    while(i<s.length())
    {
        if(isOperand(s.charAt(i)))
        {
            pf += s.charAt(i);
        }
        else if(isOperator(s.charAt(i)))
        {
            while (!s1.empty() && s1.peek() != '(' && compareOperators(s1.peek(),s.charAt(i)) <= 0)
            {
                pf += ' ';
                pf += s1.peek();
                s1.pop();
            }
            pf += ' ';
            s1.push(s.charAt(i));
        }
        else if (s.charAt(i) == '(') 
        { 
            s1.push(s.charAt(i));
        }
        else if (s.charAt(i) == ')') 
        {
            check++;
            while (!s1.empty()) 
            {
                if ((char)s1.peek() == '(') 
                { 
                    check--;
                    s1.pop(); 
                    break; 
                }
                pf += ' ';
                pf += s1.peek();
                s1.pop();
            }
        }
        i++;
    }


    while (!s1.empty()) {
        if(s1.peek()=='(')
            check--;
        pf += ' ';
        pf += s1.peek();
        pf += ' ';
        s1.pop();
    }
    if(check!=0)
        System.out.println("Syntax Error");
    else
    {
        System.out.println(pf);

    }

}