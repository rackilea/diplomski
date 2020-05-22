@MappedSuperclass
public abstract class GenericModel<T extends GenericModel> {

    private Class<T> entityClass;

    GenericModel(){
        entityClass = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public T getBy(Long id) {
        return JPA.em().find(entityClass, id);
    }

    public Long getId() {
        return id;
    }
}