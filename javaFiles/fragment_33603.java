class BuilderA extends BaseBuilder<BuilderA> {
   BuilderA buildSomethingA() { return this; }
}

class BuilderB extends BaseBuilder<BuilderB> {
   BuilderB buildSomethingB() { return this; }
}