// Option 1 (eliminating redundant 'else' clauses and nesting)
if (stl1YVal < stl2YVal)
    return -1;
if (stl1YVal > stl2YVal)
    return 1;
if (stl1XVal < stl2XVal)
    return -1;
if (stl1XVal > stl2XVal)
    return 1;
return 0;