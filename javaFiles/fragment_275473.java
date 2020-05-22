int k = ...;
for (int i = 0; i < 1000; ++ i)
    if (condition) // for example
        k = i;
// k is accessible in this scope, i is not
System.out.println(k);