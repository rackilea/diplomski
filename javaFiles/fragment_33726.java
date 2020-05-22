// ch is declared and initialised
char ch;
int space = 0;

// ch is assigned during the loop to an impure expression and has the 
// potential to vary for each iteration of the loop. This means even
// if `ch != '.'` tests true once it may not test true next iteration.
do {
    ch = (char) System.in.read();
    if (ch == ' ') space++;
} while (ch != '.');