@Inject
public PoolAnalysisFunction(IterableProvider<AnalysisFunction> candidates,
                            ChoiceFunction choice) {
    this.choice = choice;

    this.candidates = new ArrayList<>();
    candidates.forEach(this.candidates::add);
}