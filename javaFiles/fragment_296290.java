recFunc()
{
    initialization        // Sets the context
    innerRecFunc(context) // We need to pass the context to the inner function
}

innerRecFunc(context)
{
    if not test then return // could return a value
    else
    {
        loop_body             // Can update context
        counting_exp          // Can update context
        innerRecFunc(context) // Recursive call (note tail-recursion)
    }
}