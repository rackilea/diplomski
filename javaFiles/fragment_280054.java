// compute pow(base, exponent)

int result = 1;
int term = base;

while (exponent != 0)
{
  if (exponent % 2 != 0) { result *= term; }
  term = term * term;
  exponent /= 2;
}

return result;