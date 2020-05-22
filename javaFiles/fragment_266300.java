List<String[]> expected = new ArrayList<>();
expected.add(new String[]{"foo", "bar"});
expected.add(new String[]{"baz", "qux"});

List<String[]> actual = new ArrayList<>();
actual.add(new String[]{"foo", "bar"});
actual.add(new String[]{"baz", "qux"});

assertEquals(expected.size(), actual.size());
for (int i = 0; i < expected.size(); i++) {
    for (int j = 0; j < expected.get(i).length; j++) {
        Assert.assertEquals(expected.get(i)[j], actual.get(i)[j]);
    }
}