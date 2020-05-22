List<String[]> expected = new ArrayList<>();
expected.add(new String[]{"foo", "bar"});
expected.add(new String[]{"baz", "qux"});

List<String[]> actual = new ArrayList<>();
actual.add(new String[]{"foo", "bar"});
actual.add(new String[]{"baz", "qux"});

Assert.assertEquals(expected, actual); // Fails!