// Very strict - only a genuine List<T> will do
public void Foo(List<T> list)
{
    T element = list.get(0); // Valid
    list.add(element); // Valid
}

// Lax in one way: allows any List that's a List of a type
// derived from T.
public void Foo(List<? extends T> list)
{
    T element = list.get(0); // Valid
     // Invalid - this could be a list of a different type.
     // We don't want to add an Object to a List<String>
    list.add(element);   
}

// Lax in the other way: allows any List that's a List of a type
// upwards in T's inheritance hierarchy
public void Foo(List<? super T> list)
{
    // Invalid - we could be asking a List<Object> for a String.
    T element = list.get(0);
    // Valid (assuming we get the element from somewhere)
    // the list must accept a new element of type T
    list.add(element);
}