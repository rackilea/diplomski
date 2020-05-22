// Here I have one instance and one reference pointing to it
Object o = new Object();
// At this moment a copy of "o" is made and passed to "foo"
foo(o);

void foo(Object obj) {
    // In here I have obj which is a copy of whatever
    // reference was passed to me
}