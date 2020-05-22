public class AutoBeanSerializer {
    private final AutoBeanFactory factory;
    public AutoBeanSerializer(AutoBeanFactory factory) {
        this.factory = factory;
    }

    public String <T> encodeData(T data) {
        //first, get the autobean mapped to the data
        //probably throw something if we can't find it
        AutoBean<T> autoBean = AutoBeanUtils.getAutoBean(data);

        //then, encode it
        //no factory or type needed here since the AutoBean has those details
        return AutoBeanCodex.encode(autoBean);
    }
    public <T> T decodeData(Class<T> dataType, String json) {
        AutoBean<T> bean = AutoBeanCodex.decode(factory, dataType, json);

        //unwrap the bean, and return the actual data
        return bean.as();
    }
}