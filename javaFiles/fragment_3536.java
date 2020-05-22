int public lcm(int a, int b) {
  if (a >= 0 && b >= 0) {
    long gcd = lcm(-a, -b);
    return (a * b) / gcd;   // lcm(a,b) * gcd(a,b) == |a*b|
  }
  // here we simulate euclid's gcd()
  a = -a;
  b = -b;
  if (b == 0)
    return a;
  else
    return lcm(-b, -(a%b)); // neg -> simulate gcd()
}