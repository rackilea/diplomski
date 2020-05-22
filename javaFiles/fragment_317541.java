// Evaluate LHS of +, which is just a()
int tmp1 = a();

// Evaluate RHS of +, which is b() * c()
// First evaluate LHS of *, which is b()
int tmp2 = b(); 
// Next evaluate RHS of *, which is c()
int tmp3 = c();
// Now we can evaluate *:
int tmp4 = tmp2 * tmp3;

// Now we can evaluate +:
result = tmp1 + tmp4;