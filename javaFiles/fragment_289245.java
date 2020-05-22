// GOOD with Hamcrest's Matcher:
Matcher<YourObject> hasTwoProperties = (...)
doReturn(true).when(object).method(argThat(hasTwoProperties));

// GOOD with Mockito's ArgumentMatcher:
ArgumentMatcher<YourObject> hasTwoProperties = (...)
doReturn(true).when(object).method(argThat(hasTwoProperties));

// BAD because argThat is called early:
YourObject expectedObject = argThat(...);
doReturn(true).when(object).method(expectedObject);

// GOOD because argThat is called correctly within the method call:
static YourObject expectedObject() { return argThat(...); }
doReturn(true).when(object).method(expectedObject());