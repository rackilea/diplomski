public class ExcludeIfEqualStringRule implements ExclusionRule<String> {
        private final String exclusion;

        public ExcludeIfEqualStringRule(String exclusion) {
            this.exclusion = exclusion;
        }

        @Override
        public boolean isExcluded(String x) {
            return x.equals(exclusion);
        }
    }

    public abstract class AbstractExcludeIntegerRule implements ExclusionRule<Integer> {
        private final int threshold;
        private final ExclusionRule<Integer> or;

        public AbstractExcludeIntegerRule(int threshold, ExclusionRule<Integer> or) {
            this.threshold = threshold;
            this.or = or;
        }

        @Override
        public final boolean isExcluded(Integer x) {
            if (or != null) {
                return or.isExcluded(x) || doComparison(x, threshold);
            }

            return doComparison(x, threshold);
        }

        protected abstract boolean doComparison(int x, int threshold);
    }

    public class ExcludeIfGreaterThanIntegerRule extends AbstractExcludeIntegerRule {

        public ExcludeIfGreaterThanIntegerRule(int threshold, ExclusionRule<Integer> or) {
            super(threshold, or);
        }

        public ExcludeIfGreaterThanIntegerRule(int threshold) {
            this(threshold, null);
        }

        @Override
        protected boolean doComparison(int x, int threshold) {
            return x > threshold;
        }
    }

    public class ExcludeIfLessThanIntegerRule extends AbstractExcludeIntegerRule {

        public ExcludeIfLessThanIntegerRule(int threshold, ExclusionRule<Integer> or) {
            super(threshold, or);
        }

        public ExcludeIfLessThanIntegerRule(int threshold) {
            this(threshold, null);
        }

        @Override
        protected boolean doComparison(int x, int threshold) {
            return x < threshold;
        }
    }

    public class ExcludeIfEqualIntegerRule extends AbstractExcludeIntegerRule {

        public ExcludeIfEqualIntegerRule(int threshold, ExclusionRule<Integer> or) {
            super(threshold, or);
        }

        public ExcludeIfEqualIntegerRule(int threshold) {
            this(threshold, null);
        }

        @Override
        protected boolean doComparison(int x, int threshold) {
            return x == threshold;
        }
    }