NetworkIterator<Foo> iter = null;
try {
    iter = getFooIterator();
    while (iter.hasNext()) {
        Foo foo = iter.next();
        // do something with foo
    }
} catch (NetworkIteratorExceptiom e) {
    // do something with the IOException
} finally {
    iter.close();
}