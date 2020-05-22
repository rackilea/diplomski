// ch is declared and initialised
char ch = (char) System.in.read();
int space = 0;

// There are no assignments to ch in the loop, so it remains invariant 
// during the loop's execution. This means if `ch != '.'` tests true
// once it will continue testing true.
do {
    if (ch == ' ') space++;
} while (ch != '.');