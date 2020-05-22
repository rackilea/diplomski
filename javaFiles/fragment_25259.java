public abstract class AbstractService<IEntityDAO> {

    private IEntityDAO entityDAO; // you don't know the concrete implementation, maybe it's a mock for testing purpose

    public AbstractService() {
    }

    protected EntityDAO getEntityDAO() { // only subclasses need this method
    }

    public void setEntityDAO(IEntityDAO dao) { // IOC container will call this method
        this.entityDAO = dao;
    }
}