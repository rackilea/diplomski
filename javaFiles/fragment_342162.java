public class GenericService<R extends GenericRepo<T>, T> {
    protected R repo;

    public GenericService(R repo) {
        this.repo = repo;
    }

    protected T findObject() {
        return this.repo.findObject();
    }
}

public class ExtendedService extends GenericService<ExtendedRepo, Entity> {
    public ExtendedService(ExtendedRepo repo) {
        super(repo);
    }

    public Entity findObjectByWeirdKeyOnEntity(String weirdKey) {
        return this.repo.findObjectByWeirdKeyOnEntity(weirdKey);
    }
}