public class HibernateAwareObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = -4934273698008915161L;

    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate5Module());
    }

}