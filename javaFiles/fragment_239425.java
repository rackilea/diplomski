@Override
public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    if (bean instanceof LocalContainerEntityManagerFactoryBean) {
        LocalContainerEntityManagerFactoryBean factoryBean = (LocalContainerEntityManagerFactoryBean) bean;
        factoryBean.setPackagesToScan(this.packagesToScan);
        this.processed = true;
    }
    return bean;
}