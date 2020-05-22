public interface Trait2 {
  String Trait2$$super$bar();
  String bar();
}
public abstract class Trait2$class {
  public static String bar(Trait2 thiz) {
    // interface call Trait2$$super$bar() is possible
    // since FooOnSteroids implements Trait2 (see below)
    return thiz.Trait2$$super$bar() + ", Trait2";
  }
}