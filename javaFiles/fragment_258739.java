x = 1234.567;
p = 2;
x = x * pow(10, p);  // x = 123456.7
x = floor(x + 0.5);  // x = floor(123456.7 + 0.5) = floor(123457.2) = 123457
x = x / pow(10,p);   // x = 1234.57
return x;