package foo

object Foo {
  def fooStatic { println("object Foo::fooStatic") }
}

class Foo(n: Int) {
  def foo { println("class Foo::foo # " + n) }
}