@Autowired
@Qualifier("stringMatchedBasedAnswerSuggestion")
private SuggestionEvaluator stringMatchBasedEval;

private List<SuggestionEvaluator> listEvaluators;


public AnswerSuggestionServiceImpl() {
}

@PostConstruct
private void init() {
    if (listEvaluators == null) {
        listEvaluators = new ArrayList<SuggestionEvaluator>();
        // All the additional objects to be added.
        listEvaluators.add(stringMatchBasedEval);
        Collections.sort(listEvaluators, SuggestionEvaluator.compareByPriority());

    }
}