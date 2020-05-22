public static <R> R caseType(Object obj, Function<Object, Optional<R>>... functions) {
        for (Function<Object, Optional<R>> f : functions) {
            Optional<R> res = f.apply(obj);
            if (res.isPresent()) {
                return res.get();
            }
        }
        return null; // Default case (no match)
    }

    public static <T, R> Function<Object, Optional<R>> of(Class<T> cls, Function<T, R> f) {
        // Wrap the function with a type check
        return obj -> {
            if (cls.isInstance(obj)) {
                return Optional.of(f.apply((T) obj)); // As we must return a function taking an Object, we have to convert here
            } else {
                return Optional.empty();
            }
        };
    }