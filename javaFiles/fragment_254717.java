public static void main(String[] args) {
    List<Entity> entities = new ArrayList<Entity>();
    entities.add(new Entity("One", 1));
    entities.add(new Entity("Two", 2));
    entities.add(new Entity("Three", 3));
    entities.add(new Entity("Four", 4));
    Collections.sort(entities);

    for (Entity entity : entities)
        System.out.print(entity.num + " => " + entity.name + " ");
}