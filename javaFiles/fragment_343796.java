public <T extends SpriteEntity> List<T> pickEntities(Class<T> clazz) {
    List<T> result = new ArrayList<T>();
    for (SpriteEntity entity : MyGame.allEntities) {
        if (entity.getClass() == clazz) {
            result.add((T) entity);
        }
    }
    return result;
}