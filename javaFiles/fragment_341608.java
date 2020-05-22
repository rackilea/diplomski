List<String> list = getNames();

// ELEMENT = String, ACTUAL = List<? extends ELEMENT>
ListAssert<String> assertThat = assertThat(list);

// by the signature, we have to pass Condition<? super ELEMENT> or Condition<? super ACTUAL>
// Condition<? super ACTUAL> = Condition<? super List<? extends String>>
Condition<List<? extends String>> condition = sameNamesAs(list);

// Condition<List<? extends String>> extends Condition<? super List<? extends String>>
assertThat.has(condition);