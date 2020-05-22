public class PermutationProvider<T, U, V> {
        private final List<T> tItems;
        private final List<U> uItems;
        private final List<V> vItems;
        private final List<ExclusionEvaluator<T, U, V>> exclusionEvaluators;

        public PermutationProvider(List<T> tItems, List<U> uItems, List<V> vItems, List<ExclusionEvaluator<T, U, V>> exclusionEvaluators) {
            this.tItems = tItems;
            this.uItems = uItems;
            this.vItems = vItems;
            this.exclusionEvaluators = exclusionEvaluators;
        }

        public List<Permutation<T, U, V>> getCombinations() {
            List<Permutation<T, U, V>> combinations = new ArrayList<>();
            for (T tElement : tItems) {
                for (U uElement : uItems) {
                    for (V vElement : vItems) {
                        Permutation<T, U, V> p = new Permutation<>(tElement, uElement, vElement);
                        if (isExcluded(tElement, uElement, vElement)) {
                            System.out.println(p + " IS EXCLUDED");
                        } else {
                            combinations.add(p);
                        }
                    }
                }
            }

            return combinations;
        }

        private boolean isExcluded(T tElement, U uElement, V vElement) {
            for (ExclusionEvaluator<T, U, V> exclusionEvaluator : exclusionEvaluators) {
                if (exclusionEvaluator.isExcluded(tElement, uElement, vElement)) {
                    return true;
                }
            }

            return false;
        }
    }