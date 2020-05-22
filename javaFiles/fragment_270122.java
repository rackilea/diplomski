if(character == '*' || character == '-' || character == '/' || character == '+')
{
    postFix += ' '; // <-- add space here
    while(!stack.empty() && precedence(stack.peek(), character)){
        postFix += stack.pop();
    }//end while
    stack.push(character);
}