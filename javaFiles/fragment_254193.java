/**
 * Matches all Foo objects in an order agnostic manner.
 * @param expected The collection of Foo objects to be matched.
 * @return A matcher that will match a collection of Foos
 */
@SuppressWarnings("unchecked")
public static Matcher<Iterable<? extends Foo>> matchesAllfoos(Collection<Foo> expected)
{
    if (expected == null)
    {
        return new IsNull<Iterable<? extends Foo>>();
    }

    // The cast is here to provide a hint to Java as to which overloaded method to choose.
    // See http://stackoverflow.com/questions/18614621/conflicting-overloads-for-hamcrest-matcher
    return containsInAnyOrder((Collection)Collections2.transform(expected, FOO_TO_MATCHER));
}