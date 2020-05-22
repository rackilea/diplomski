class MyValidator {
    private Map<Rule<?>, RuleNode<?>> map = new HashMap<>();

    public void validate() throws Exception {
        for(RuleNode<?> node : map.values())
            node.apply();
    }

    public <T, D extends T> void addRule(Rule<T> rule, D data) {
        @SuppressWarnings("unchecked") // unchecked, but safe due to encapsulation
        RuleNode<T> r = (RuleNode<T>) map.get(rule);
        if(r == null) {
            r = new RuleNode<T>(rule);
            map.put(rule, r);
        }

        r.add(data);
    }

    private static class RuleNode<T> { // Maintains that the rule and data are compatible
        private final Rule<T> rule;
        private final List<T> list = new ArrayList<>();

        public RuleNode(Rule<T> rule) {
            this.rule = rule;
        }

        public void add(T data) {
            list.add(data);
        }

        public void apply() throws Exception {
            for(T data : list)
                rule.applyRule(data);
        }
    }
}