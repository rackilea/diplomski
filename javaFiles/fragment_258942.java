public long fibb()
{
    int a = 1, b = 1;
    long total = 0;

    while (a + b < 4000000) {
        // Calculate the next number.
        int c = a + b;

        // Check if it's even.
        if (c % 2 == 0) {
            total += c;
        }

        // Shift the values.
        a = b;
        b = c;
    }     

    return total;
}