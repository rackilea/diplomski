Let's say the x = 123.

int rev = 0;

rev = rev * 10 + x % 10; // rev = 3,   1st iteration.

x = x/10;              // x = 12

rev = rev * 10 + x % 10;  // rev = 3 * 10 + 2 = 32,  2nd iteration

x = x/10;              // x = 1

rev = rev * 10 + x % 10;  // rev = 32 * 10 + 1 = 321, 3rd iteration.

x = 0 so the  loop terminates after 3 iterations for 3 digits.