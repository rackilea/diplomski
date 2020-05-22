class SubsetExample
    implements Problem<ISeq<MyObject>, EnumGene<MyObject>, Double>
{
    // Define your basic set here.
    private final ISeq<MyObject> basicSet = ISeq.empty();
    private final int subSetSize = 5;

    @Override
    public Function<ISeq<MyObject>, Double> fitness() {
        return subSet -> {
            assert(subset.size() == subSetSize);
            double fitness = 0;
            for (MyObject obj : subSet) {
                // Do some fitness calculation
            }

            return fitness;
        };
    }

    @Override
    public Codec<ISeq<MyObject>, EnumGene<MyObject>> codec() {
        return codecs.ofSubSet(basicSet, subSetSize);
    }

    public static void main(final String[] args) {
        final SubsetExample problem = new SubsetExample()

        final Engine<EnumGene<MyObject>, Double> engine = Engine.builder(problem)
            .minimizing()
            .maximalPhenotypeAge(5)
            .alterers(
                new PartiallyMatchedCrossover<>(0.4),
                new Mutator<>(0.3))
            .build();

        final Phenotype<EnumGene<MyObject>, Double> result = engine.stream()
            .limit(limit.bySteadyFitness(55))
            .collect(EvolutionResult.toBestPhenotype());

        System.out.print(result);
    }
}