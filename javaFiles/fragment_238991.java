private void stripNonProperties(final ClassModelBuilder<T> builder, Class<T> type) {
    // Need intermediary list. Can't remove from list while iterating over it
    final ArrayList<String> names = new ArrayList<>();

    for (final org.bson.codecs.pojo.PropertyModelBuilder<?> property : builder.getPropertyModelBuilders()) {
        final String name = property.getName();
        if (!isField(name, type)) {
            names.add(name);
        }
    }

    for (final String name : names) {
        builder.removeProperty(name);
    }
}