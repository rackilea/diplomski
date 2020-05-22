class MyBeanProxy implements MyBean {

    MyBeanImpl theBean;

    public void foo() {
        // aspect code
        theBean.foo();
    }
    public void bar() {
        // aspect code
        theBean.bar();
    }
}