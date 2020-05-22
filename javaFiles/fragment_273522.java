package de.scrum_master.app;

public interface IEntityController<T> {
    public void setEntity(T entity);
    public T getEntity();

    static aspect EntityControllerAspect {
        private T IEntityController.entity;
        public void IEntityController.setEntity(T entity) { this.entity = entity; }
        public T IEntityController.getEntity() { return entity; }

        declare parents : @EntityController * implements IEntityController;
    }
}