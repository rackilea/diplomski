int x;
int y;
/* Declares 'ptr' as a pointer, and says that it points to an int.
   The pointed-to type is used by the compiler for type checking
   and type conversions. */
int *ptr;

ptr = &x; // Store the address of 'x' in 'ptr'.
*ptr = 1; // Store 1 into the memory 'ptr' points to ('x').
ptr = &y; // Store the address of 'y' in 'ptr'.
*ptr = 2; // Store 2 into the memory 'ptr' points to ('y').