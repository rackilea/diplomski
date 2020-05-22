class Adv {
  @OnMethodEnter(skipOn = OnNonDefaultValue.class)
  static boolean intercept(@This ClassWithPrivateMethod self) {
    if (self instanceof ParentClass) {
      // Your code
      return true;
    } else {
      return false;
    }
  }
}