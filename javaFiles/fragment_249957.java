public static String infixToPostfix(char[] expressionArray, CharStack opStack){
    String output = "";
    int length = expressionArray.length;
    for(int i = 0; i < length; i++){    
        if(isOperatorOrBracket(expressionArray[i])){ 
            if(priorityAtInput(expressionArray[i]) >= priorityAtStack(opStack.peek())){
                opStack.push(expressionArray[i]);
            }else if(priorityAtInput(expressionArray[i]) < priorityAtStack(opStack.peek())){
                while(priorityAtInput(expressionArray[i]) < priorityAtStack(opStack.peek())){
                    output = output + opStack.pop();
                    if(opStack.peek() == '('){
                        opStack.pop();
                        break;
                    }else if(priorityAtInput(expressionArray[i]) >= priorityAtStack(opStack.peek())){
                        opStack.push(expressionArray[i]);
                        break;
                    }
                }
            }else{
                while(opStack.peek() != '('){
                    output = output + opStack.pop();
                }
                opStack.pop();
            }
        }else{
            output = output + expressionArray[i];
        }
    }
    while(!opStack.empty()){
        if(opStack.peek() != '('){
            output = output + opStack.pop();
        }else if(opStack.peek() == '('){
            opStack.pop();
        }
    }
    return output;
}