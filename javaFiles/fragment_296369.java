int result = 0;

if (a)
    result += recursiveFunc(x + 1);
if (b)
    result += recursiveFunc(x + 2);
if (c)
    result += recursiveFunc(x + 3);

return result;