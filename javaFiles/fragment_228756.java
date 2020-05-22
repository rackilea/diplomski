private static final ISeq<Integer> ITEMS = IntStream.rangeClosed(1, 10)
    .boxed()
    .collect(ISeq.toISeq());

public Codec<ISeq<List<Integer>>, IntegerGene> codec(final int knapsackCount) {
    return Codec.of(
        Genotype.of(IntegerChromosome.of(
            0, knapsackCount, ITEMS.length())
        ),
        gt -> {
            final ISeq<List<Integer>> knapsacks = IntStream.range(0, knapsackCount)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(ISeq.toISeq());

            for (int i = 0; i < ITEMS.length(); ++i) {
                final IntegerGene gene = gt.get(0, i);
                if (gene.intValue() < knapsackCount) {
                    knapsacks.get(gene.intValue()).add(ITEMS.get(i));
                }
            }

            return knapsacks;
        }
    );
}