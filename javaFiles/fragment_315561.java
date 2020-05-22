struct Foo {
    int x = 0;
}

int Foo_mulBy(Foo *this, int y) {
    return this->x * y;
}

Foo* foo = new Foo();
Foo_mulBy(foo, 3)