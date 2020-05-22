public class MockitoFactoryBean<T> implements FactoryBean<T> {
    private Class<T> classToBeMocked;

    public MockitoFactoryBean(Class<T> classToBeMocked) {
        this.classToBeMocked = classToBeMocked;
    }

    @Override
    public T getObject() throws Exception {
        return Mockito.mock(classToBeMocked);
    }
....