try {
  // set a bad age to Mr Frodo which is really 33 years old.
  frodo.setAge(50);
  // you can specify a test description with as() method or describedAs(), it supports String format args
  assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(33);
} catch (AssertionError e) {
  assertThat(e).hasMessage("[check Frodo's age] expected:<[33]> but was:<[50]>");
}