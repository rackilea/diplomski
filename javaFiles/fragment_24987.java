/**
 * Verifies that the actual group of objects does not contain the given objects.
 *
 * @param objects the objects that the group of objects should exclude.
 * @return this assertion object.
 * @throws AssertionError       if the actual group of objects is {@code null}.
 * @throws NullPointerException if the given array is {@code null}.
 * @throws AssertionError       if the actual group of objects contains any of the given objects.
 */
public final @Nonnull S excludes(@Nonnull Object... objects) {
    assertExcludes(objects);
    return myself();
}