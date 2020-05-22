List<Integer> expected = Arrays.asList(1, 2, 3);
long count = objects.stream()
    .map(MyObject::getId)
    .filter(id -> expected.contains(id.intValue()))
    .count();
Assert.assertEquals(objects.size(), (int) count);