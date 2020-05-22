trait T {
  def x: this.type
}

class C extends T {
  def x = this
}

val x: T = new C
x.x // has type x.type (which is a subtype of C), not type T