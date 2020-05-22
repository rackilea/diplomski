public ArrayList foo (SomeType x) {
    return foo(x, new ArrayList());
}

private ArrayList foo(SomeType x, ArrayList list) {
    // Perform your recursion here, which probably shouldn't be in a loop.
    if (someCondition) {
        list.add(z);
        foo(y, list);
    }
    return list;
}