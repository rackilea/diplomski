//all this would be valid
List<Test<Double>> doubleTests = null;
List<Test<? extends Number>> numberTests = assign(doubleTests);

Test<Integer> integerTest = null;
numberTests.add(integerTest); //type error, now doubleTests contains a Test<Integer>