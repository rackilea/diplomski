public class ExclusionEvaluator<T, U, V> {
        private final ExclusionRule<T> tRule;
        private final ExclusionRule<U> uRule;
        private final ExclusionRule<V> vRule;

        public ExclusionEvaluator(ExclusionRule<T> tRule, ExclusionRule<U> uRule, ExclusionRule<V> vRule) {
            this.tRule = tRule;
            this.uRule = uRule;
            this.vRule = vRule;
        }

        public boolean isExcluded(T t, U u, V v) {
            return tRule.isExcluded(t) && uRule.isExcluded(u) && vRule.isExcluded(v);
        }
    }