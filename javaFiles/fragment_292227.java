interface DoIt { void doSomething() }
class ParentDoIt implements DoIt ...
  same for Childs

class DoItFactory {
  DoIt getDoIt(Parent p) {
     if (p instanceof Child1) return new Child1DoIt(p)
     ...