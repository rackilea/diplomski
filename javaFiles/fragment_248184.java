class ABUtils {
  A getBar() { new B() }
}

new ABUtils().bar.with {
  assert it instanceof A
  assert it instanceof B
}