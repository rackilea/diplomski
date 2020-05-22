trait Trait1 extends Foo {
  abstract override def bar = super.bar + ", Trait1"
}

trait Trait2 extends Foo {
  abstract override def bar = super.bar + ", Trait2"
}