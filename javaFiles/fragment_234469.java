private static <R> Optional<R> caseTypeNonNull(Object obj, Function<Object, Optional<R>>... functions) {
        for (Function<Object, Optional<R>> f : functions) {
            Optional<R> res = f.apply(obj);
            if (res.isPresent()) {
                return Optional.of(res.get());
            }
        }
        return Optional.empty(); // Default case (no match)
    }