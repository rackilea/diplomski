public CopyOnWriteArrayList(Collection<? extends E> c) {
        Object[] elements = c.toArray();

        if (elements.getClass() != Object[].class)
            elements = Arrays.copyOf(elements, elements.length, Object[].class);
        setArray(elements);
    }