private final E entity;
private final Class<E> clazz;

public Dao(E entity, Class<E> clazz) {  
    this.entity = entity;
    this.clazz = clazz;
}