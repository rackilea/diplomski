private void foo(Class<?> cls) {
    if (cls == String.class) { ... }
    else if (cls == int.class) { ... }
}

private void bar() {
    foo(String.class);
}