class Foo {
  def getBar() { 'get bar' }
  def bar() { 'method bar' }
}

foo = new Foo()

assert "$foo.bar()".toString() == "get bar()"
assert "${foo.bar()}".toString() == "method bar"