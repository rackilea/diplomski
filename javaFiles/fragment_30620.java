@Override
public BeanExt method(BeanExt bean, Object data) {
        BeanExt beanExt = (BeanExt) session;
        beanExt.setFname("John");
        beanExt.setLname("Doe");
        beanExt.setPhoneNum("123456789");
        return beanExt;
}