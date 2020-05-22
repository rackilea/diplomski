@groovy.transform.TupleConstructor
class Foo {
    final boolean bar
    final boolean baz
    final boolean boo
}

new Foo(bar: true, baz: false, boo: true)