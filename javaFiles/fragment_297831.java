public MockitoMockFactoryBean implements FactoryBean<?>
{
    private Class<?> objectType;

    @Override public Object getObject()
    {
        return Mockito.mock(objectType);
    }
    public void setObjectType(Class<?> objectType)
    {
        this.objectType=objectType;
    }
    @Override public Class<?> getObjectType()
    {
        return objectType;
    }
}