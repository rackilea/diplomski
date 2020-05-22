int A = 0b0001;
int B = 0b0100;
// A | B = 0101 (bitwise or)


style ^= A; // If off, turn on.  If on, turn off.

style = A|B; // 0101
style ^= A; // style now equals 0100
style ^= A; // style now equals 0101