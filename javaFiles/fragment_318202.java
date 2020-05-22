else if(operator(ch))
{
    if(prech(stack1[top])==0||(prech(stack1[top])<=prech(ch))||(prech(stack1[top])=='('))
                push(ch);
}
else if(prech(stack1[top]) > prech(ch))