List<Class<?>> classes = new ArrayList<>();
classes.add(String.class);
classes.add(int.class);
classes.add(RandomClass.class);

for (int i = 0; i < list.size(); i++) {
    if (classes.get(i).isInstance(list.get(i))) {
        ...
    }
}