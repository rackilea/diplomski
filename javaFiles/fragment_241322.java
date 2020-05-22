public abstract class GenericModel<T extends GenericModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public T getBy(Long id) {
        return JPA.em().find(????, id);
    }
}