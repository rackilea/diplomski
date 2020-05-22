interface Maker {
    SomeClass make(A obj);
}

class MakerForB implements Maker {
    SomeClass make(A obj);
}