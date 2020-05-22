n--; // n becomes 5;
n |= n >> 1; // This is equivalent to n = n | n >> 1.
            // Bit shift >> has higher precedence than bitwise OR |.
            // This is why it becomes 7. Try it yourself and read about
            // these operators.
n |= n >> 2; // n is 7
n |= n >> 4; // n is 7
n |= n >> 8; // n is 7
n |= n >> 16; // n is 7
n++; // n is 8
return n; // return n which is equal to 8 - the next nearest to 6 power of 2.