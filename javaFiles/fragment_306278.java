int factorial_helper(int acc, int x) {
   if (x == 0) return acc;
   else return factorial_helper(acc*x, x-1);
}

int factorial(int x) { return factorial_helper(1, x); }