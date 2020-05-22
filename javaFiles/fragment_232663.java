@Component
public class PersonFactory implements FactoryBean<Person> {
    public Person getObject() throws Exception {
        return Person.INSTANCE;
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    public boolean isSingleton() {
        return true;
    }
}