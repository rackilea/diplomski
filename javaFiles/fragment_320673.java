int insertIndex = target;
for (int i = 0; i < n; i++) {
    if (fromList.size() > start) {
        String removed = fromList.remove(start);
        toList.add(insertIndex, removed);
        insertIndex++;
    }
}