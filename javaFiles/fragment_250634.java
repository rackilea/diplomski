public void setValue(Object value) {
    if (value == null && this.nullAsEmptyCollection) {
        super.setValue(createCollection(this.collectionType, 0));
    }
    else if (value == null || (this.collectionType.isInstance(value) && !alwaysCreateNewCollection())) {
        // Use the source value as-is, as it matches the target type.
        super.setValue(value);
    }
    else if (value instanceof Collection) {
        // Convert Collection elements.
        Collection source = (Collection) value;
        Collection target = createCollection(this.collectionType, source.size());
        for (Object elem : source) {
            target.add(convertElement(elem));
        }
        super.setValue(target);
    }
    else if (value.getClass().isArray()) {
        // Convert array elements to Collection elements.
        int length = Array.getLength(value);
        Collection target = createCollection(this.collectionType, length);
        for (int i = 0; i < length; i++) {
            target.add(convertElement(Array.get(value, i)));
        }
        super.setValue(target);
    }
    else {
        // A plain value: convert it to a Collection with a single element.
        Collection target = createCollection(this.collectionType, 1);
        target.add(convertElement(value));
        super.setValue(target);
    }
}


protected Collection createCollection(Class collectionType, int initialCapacity) {
    if (!collectionType.isInterface()) {
        try {
            return (Collection) collectionType.newInstance();
        }
        catch (Exception ex) {
            throw new IllegalArgumentException(
                    "Could not instantiate collection class [" + collectionType.getName() + "]: " + ex.getMessage());
        }
    }
    else if (List.class.equals(collectionType)) {
        return new ArrayList(initialCapacity);
    }
    else if (SortedSet.class.equals(collectionType)) {
        return new TreeSet();
    }
    else {
        return new LinkedHashSet(initialCapacity);
    }
}