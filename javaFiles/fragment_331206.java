public class PermuteWithExclusionsApp {

    public static void main(String[] args) {
        new PermuteWithExclusionsApp().permute();
    }

    private void permute() {
        List<String> p1 = Arrays.asList("Lion", "Chair", "Snow");

        List<Integer> p2 = new ArrayList<>();
        for (int i = 0; i <= 28; i++) {
            p2.add(i);
        }

        List<Integer> p3 = new ArrayList<>();
        for (int i = 34; i <= 39; i++) {
            p3.add(i);
        }

        // read from a file or some other source
        List<String> compoundExclusionRules = Arrays.asList("P1 = Lion && P2 > 23 && P3 <= 35", "P1 = Lion && P2 < 13 && P3 >= 37", "P1 = Chair && P2 < 7 && P3 = 34");

        ExclusionRuleFactory<String> stringRuleFactory = new StringExclusionRuleFactory();
        ExclusionRuleFactory<Integer> integerRuleFactory = new IntegerExclusionRuleFactory();
        ExclusionEvaluatorFactory<String, Integer, Integer> evaluatorFactory = new ExclusionEvaluatorFactory<>(stringRuleFactory, integerRuleFactory, integerRuleFactory);

        List<ExclusionEvaluator<String, Integer, Integer>> evaluators = new ArrayList<>();
        for (String compoundExclusionRule : compoundExclusionRules) {
            evaluators.add(evaluatorFactory.create(compoundExclusionRule));
        }

        //      List<ExclusionEvaluator<String, Integer, Integer>> evaluators = new ArrayList<>();
        //      evaluators.add(getExclusionRul1());
        //      evaluators.add(getExclusionRul2());
        //      evaluators.add(getExclusionRul3());

        PermutationProvider<String, Integer, Integer> provider = new PermutationProvider<>(p1, p2, p3, evaluators);
        List<Permutation<String, Integer, Integer>> permuations = provider.getCombinations();
        for (Permutation<String, Integer, Integer> p : permuations) {
            System.out.println(p);
        }
    }

    //  private ExclusionEvaluator<String, Integer, Integer> getExclusionRul3() {
    //      ExclusionRule<String> p1Rule = new ExcludeIfEqualStringRule("Chair");
    //      ExclusionRule<Integer> p2Rule = new ExcludeIfLessThanIntegerRule(7);
    //      ExclusionRule<Integer> p3Rule = new ExcludeIfEqualIntegerRule(34);
    //      return new ExclusionEvaluator<String, Integer, Integer>(p1Rule, p2Rule, p3Rule);
    //  }
    //
    //  private ExclusionEvaluator<String, Integer, Integer> getExclusionRul2() {
    //      ExclusionRule<String> p1Rule = new ExcludeIfEqualStringRule("Lion");
    //      ExclusionRule<Integer> p2Rule = new ExcludeIfLessThanIntegerRule(13);
    //      ExclusionRule<Integer> p3Rule = new ExcludeIfGreaterThanIntegerRule(37, new ExcludeIfEqualIntegerRule(37));
    //      return new ExclusionEvaluator<String, Integer, Integer>(p1Rule, p2Rule, p3Rule);
    //  }
    //
    //  private ExclusionEvaluator<String, Integer, Integer> getExclusionRul1() {
    //      ExclusionRule<String> p1Rule = new ExcludeIfEqualStringRule("Lion");
    //      ExclusionRule<Integer> p2Rule = new ExcludeIfGreaterThanIntegerRule(23);
    //      ExclusionRule<Integer> p3Rule = new ExcludeIfLessThanIntegerRule(35, new ExcludeIfEqualIntegerRule(35));
    //      return new ExclusionEvaluator<String, Integer, Integer>(p1Rule, p2Rule, p3Rule);
    //  }