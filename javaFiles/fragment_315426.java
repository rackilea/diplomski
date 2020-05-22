...
    stack.pop();

} else 
if (OperantValues(c) > -1) { // Operator

    while (!stack.isEmpty() && OperantValues(c) <= OperantValues(stack.peek()))
        sb.append(c);
    stack.push(c);
} 
else   // other characters including space
{
    continue; // we'll ignore them for now
}