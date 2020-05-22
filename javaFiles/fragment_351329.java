// Accept an array of character arrays and print a nest
// of their contents.
static void print(char [] [] a) {
    int n_arrays = a.length;
    int [] indices = new int[n_arrays];  // All set to 0 by java
    // Decrement so that first increment is to all zeros. Avoids test for empty arrays.
    indices[n_arrays - 1] = -1; 
    for (int j = 0;;) {
        // Increment indices.
        for (j = n_arrays - 1; j >= 0; j--) {
            if (++indices[j] >= a[j].length) {
                indices[j] = 0;
            }
            else {
                break;  // No overflow. Increment is complete.
            }
        }
        if (j < 0) {
            break; // Last index overflowed.  We're done.
        }
        // Print.
        for (int i = 0; i < n_arrays; i++) {
            System.out.print(a[i][indices[i]]);
        }
        System.out.println();
    }
}

// Varargs version.
static void printArgs(char [] ... a) {
    print(a);
}

static char [] one = {'a','b','c'};
static char [] two = {'1','2','3'};
static char [] three = {'x','y','z'};

public static void main(String[] a) {
    print(new char [] [] { one, two, three } );
    printArgs(one, two, three);
}