@Test
public void testCollect() {
    Stream<String> stream = Streams.defer(Arrays.asList("1", "2", "3", "4", "5")).get();
    stream.map(Integer::parseInt)
            .collect()
            .consume(integers -> assertThat(integers, Matchers.contains(1, 2, 3, 4, 5)));
}