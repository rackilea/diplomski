@Override
public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    // DO SOMETHING HERE WITH THE BEAN before initialization
    return bean;
}

@Override
public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    //DO SOMETHING HERE WITH THE BEAN after INITIALIZATION
    return bean;
}