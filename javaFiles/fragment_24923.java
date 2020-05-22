class Base { void foo() { ... } }
class Derived extends Base { @Override void foo() { ... } }


{ new Derived().foo(); }  // Dynamically dispatched to Derived.foo.
{
  Base x = new Base();
  x.foo();                // Dynamically dispatched to Base.foo.
  x = new Derived();      // x's static type is still Base.
  x.foo();                // Dynamically dispatched to Derived.foo.
}