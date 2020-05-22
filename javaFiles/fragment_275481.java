public class EasyMockFactoryBean<T> implements FactoryBean<T> {
    private Class<T> mockedClass;

    public void setMockedClass(Class mockedClass) {
        this.mockedClass = mockedClass;
    } 

    public T getObject() throws Exception {
        return EasyMock.createMock(mockedClass);
    }

    public Class<T> getObjectType() {
        return mockedClass;
    }

    public boolean isSingleton() {
        return true;
    } 

}