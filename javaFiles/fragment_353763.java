abstract class Bear extends Animal<BearDef> {}

class BlackBear extends Bear {
  // make use of covariant return type to make BlackBear return correct def
  @Override
  BlackBearDef getDef() { ... }
}