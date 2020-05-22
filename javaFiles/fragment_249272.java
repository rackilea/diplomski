E list = factory.get();
List<T> colAsList = new ArrayList<>(collection);
for (int i = 0; i < size; i++) {
    int r = MathUtils.randomInt(0, colAsList.size() - 1);
    list.add(colAsList.remove(r));
}
collection.removeAll(list);
return list;