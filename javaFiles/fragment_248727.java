Entity entity = new Entity();
for(Field f : entity.getClass().getDeclaredFields()) {
    try {
        f.setAccessible(true);
        System.out.println(f.get(entity));
    } catch(IllegalAccessException e) {
        e.printStackTrace();
    }
}