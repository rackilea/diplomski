private Map<Long, Set<Long>> buildModel(long[][] originalModel) {
    final Map<Long, Set<Long>> model = new LinkedHashMap<Long, Set<Long>>();
    for (int i = 0; i < originalModel.length; i++) {
        model.put(originalModel[i][0], new LinkedHashSet<Long>());
    }

    for (int i = 0; i < originalModel.length; i++) {
        final Long key = originalModel[i][0];
        for (int j = 1; j < originalModel[i].length; j++) {
            model.get(key).add(originalModel[i][j]);
        }
    }

    return model;
}