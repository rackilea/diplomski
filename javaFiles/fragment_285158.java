public String doTrans() // do translation to postfix
    {
        for(int j=0; j<input.length(); j++)
        {
            char ch = input.charAt(j);
            theStack.displayStack("For "+ch+" "); // *diagnostic*
            switch(ch)
            {
                case '+': // its + or -
                case '-':
                    output += " ";
                    gotOper(ch, 1); // go pop operators
                    break; // (precedence 1)

                case '*': // its * or / or $
                case '/':
                case '$':
                    output += " ";
                    gotOper(ch, 2); // go pop operators
                    break; // (precedence 2)

                case '(': // its a left paren
                    theStack.push(ch); // push it
                    break;

                case ')': // its a right paren
                    output += " ";
                    gotParen(ch); // go pop operators
                    break;

                default: // must be an operand
                    output = output + ch ; // write it to output
                    break;

            }// end switch
        } // end for
        output += " ";
        while( !theStack.isEmpty() ) // pop remaining opers
        {
            theStack.displayStack("While "); // *diagnostic*
            output += theStack.pop(); // write to output
        }
        theStack.displayStack("End "); // *diagnostic*
        return output; // return postfix
    } // end doTrans()