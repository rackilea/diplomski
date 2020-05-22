public interface ExclusionRuleFactory<Z> {
        public ExclusionRule<Z> create(String operator, String operand);
    }

    public class StringExclusionRuleFactory implements ExclusionRuleFactory<String> {

        @Override
        public ExclusionRule<String> create(String operator, String operand) {
            return new ExcludeIfEqualStringRule(operand);
        }
    }

    public class IntegerExclusionRuleFactory implements ExclusionRuleFactory<Integer> {

        @Override
        public ExclusionRule<Integer> create(String operator, String operand) {
            int threshold = Integer.parseInt(operand);

            switch (operator) {
            case "=":
                return new ExcludeIfEqualIntegerRule(threshold);

            case ">":
                return new ExcludeIfGreaterThanIntegerRule(threshold);

            case "<":
                return new ExcludeIfLessThanIntegerRule(threshold);

            case ">=":
                return new ExcludeIfGreaterThanIntegerRule(threshold, new ExcludeIfEqualIntegerRule(threshold));

            case "<=":
                return new ExcludeIfLessThanIntegerRule(threshold, new ExcludeIfEqualIntegerRule(threshold));
            }

            throw new IllegalArgumentException("Unsupported operator " + operator);
        }
    }

    public class ExclusionEvaluatorFactory<T, U, V> {
        private final ExclusionRuleFactory<T> p1RuleFactory;
        private final ExclusionRuleFactory<U> p2RuleFactory;
        private final ExclusionRuleFactory<V> p3RuleFactory;

        public ExclusionEvaluatorFactory(ExclusionRuleFactory<T> p1RuleFactory, ExclusionRuleFactory<U> p2RuleFactory, ExclusionRuleFactory<V> p3RuleFactory) {
            this.p1RuleFactory = p1RuleFactory;
            this.p2RuleFactory = p2RuleFactory;
            this.p3RuleFactory = p3RuleFactory;
        }

        public ExclusionEvaluator<T, U, V> create(String compoundExclusionRule) {
            ExclusionRule<T> p1Rule = null;
            ExclusionRule<U> p2Rule = null;
            ExclusionRule<V> p3Rule = null;

            String[] exclusionSubRules = compoundExclusionRule.split("&&");
            for (int sr = 0; sr < exclusionSubRules.length; sr++) {

                String[] ruleParts = exclusionSubRules[sr].trim().split(" ");
                String whichRule = ruleParts[0].trim(); 
                String operator = ruleParts[1].trim();
                String operand = ruleParts[2].trim();

                switch (whichRule) {
                case "P1":
                    p1Rule = p1RuleFactory.create(operator, operand);
                    break;

                case "P2":
                    p2Rule = p2RuleFactory.create(operator, operand);
                    break;

                case "P3":
                    p3Rule = p3RuleFactory.create(operator, operand);
                    break;
                }
            }

            return new ExclusionEvaluator<T, U, V>(p1Rule, p2Rule, p3Rule);
        }
    }