/**
 * The parameters in the wrapped C++ method are all  optional,
 * so we had to write an overload for each parameter combination.
 * @param i the int parameter used for x. 
 * @param s the string parameter used for y.
 * @param d the double parameter used for z.
 */
void foo(int i, String s, double d);

/**
 * Overload of the {@link #foo(int, String, double)} method with a default {@code d}.
 */
void foo(int i, String s);

/**
 * @see #foo(int, String, double)
 */
void foo(int i, double d);

...