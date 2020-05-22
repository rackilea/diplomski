// First, the array is created, then it is stored into a variable.

// At last, store the result of code below into a String[].
String str[] =

// Create a two-dimensional array
new String[][] {
    // Add the first element to the two-dimensional array,
    // which is in fact a String[] with one null element in it.
    /* element #0 */ new String[] { null },

    // Add the second element to the two-dimensional array:
    // it's a String[] containing three strings
    /* element #1 */ new String[] { "a", "b", "c" },

    // Then add the third element to the two-dimensional array,
    // which is an empty string.
    /* element #2 */ new String[] { new String() }
}

// Then get the first element of our two-dimensional array,
// which returns a String[] with one null element in it.
[0];