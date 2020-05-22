Map<String, Pair<Long, Double>> map = ImmutableMap.of(
        "a", Pair.of(1L, 1.0d),
        "b", Pair.of(1L, 1.0d),
        "c", Pair.of(1L, 1.0d),
        "d", Pair.of(1L, 1.0d)
);

@Test
public void should2()
{
    final ImmutableSortedMap<String, Pair<Long, Double>> sortedMap = sortInDescendingSizeOrder(map);
    assertThat(sortedMap).hasSize(4);
    System.out.println(sortedMap); // {a=(1,1.0), b=(1,1.0), c=(1,1.0), d=(1,1.0)}
}