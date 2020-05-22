interface Trait1 {
  String Trait1$$super$bar();
  String bar();
}
abstract class Trait1$class {
  public static String bar(Trait1 thiz) {
    // interface call Trait1$$super$bar() is possible
    // since FooOnSteroids implements Trait1 (see below)
    return thiz.Trait1$$super$bar() + ", Trait1";
  }
}