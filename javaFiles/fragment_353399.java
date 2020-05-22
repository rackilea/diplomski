Matcher<MyClass> matcher = CoreMatchers.allOf(
  HasPropertyWithValue.hasProperty("myField1", getMyField1()),
  HasPropertyWithValue.hasProperty("myField2", getMyField2()));
if (!matcher.matches(obj)){
  System.out.println(matcher.describeFailure(obj));
  return false;
}
return true;