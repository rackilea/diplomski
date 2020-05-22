private static final EnumMap<Status, String> VALUE_MAP = new EnumMap<>(Status.class);
static {
    Arrays.stream(Category.values()).forEach(category -> {
        category.status.forEach(status -> {
            VALUE_MAP.put(status, category.category);
        });
    });
}