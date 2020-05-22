static List<String> words = Arrays.asList("Hello", "Bonjour", "engine");

static public <E, Coll extends Collection<E>> Coll as(Class<? extends Collection> collClass, Class<E> elemClass) {
    if (collClass.isInstance(words)) {
        Collection coll = collClass.cast(words);
        for (Object o : coll)
            if (!elemClass.isInstance(o))
                throw new ClassCastException("BAM");
        return (Coll)coll;
    }

    return null;
}