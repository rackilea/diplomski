class SomeAdvice {
  @Avice.OnMethodEnter 
  static void enter() {...}
  @Advice.OnMethodExit 
  static void exit(@Advice.Return(readOnly = false) Object val) {
    val = "some other value";
  }
}