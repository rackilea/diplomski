class MyDefaultMessageListenerContainer extends DefaultMessageListenerContainer {
    public getMyBeanName() { return getBeanName(); }
}

MyDefaultMessageListenerContainer container = new MyDefaultMessageListenerContainer();
String name = container.getMyBeanName();