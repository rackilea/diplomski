void myMethod(int depth) {
    /* ... Do something ... */
    if (depth < maxDepth) {
        child.myMethod(depth + 1);
    }
}