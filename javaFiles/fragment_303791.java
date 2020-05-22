ReflectionComparatorMode[] modes = {ReflectionComparatorMode.LENIENT_ORDER, ReflectionComparatorMode.IGNORE_DEFAULTS};

List<org.unitils.reflectionassert.comparator.Comparator> comparators = new ArrayList<>();
    comparators.add(new Comparator() {
         @Override
         public boolean canCompare(Object left, Object right) {
               return left instanceof String && right instanceof String;
         }

         @Override
         public Difference compare(Object left, Object right, boolean onlyFirstDifference, ReflectionComparator reflectionComparator) {
               return  ((String) left).equalsIgnoreCase((String) right) ? null : new Difference("Non equal values: ", left, right);
         }
});

comparators.addAll(
    new ReflectionComparatorFactory() {
        public List<Comparator> getComparatorChainNonStatic(Set<ReflectionComparatorMode> modes) {
               return getComparatorChain(modes);
        }
    }.getComparatorChainNonStatic(asSet(modes)));

ReflectionComparator comparator = new ReflectionComparator(comparators);