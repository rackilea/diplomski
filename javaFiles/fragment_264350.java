interface MyRemoteInterface {
    void foo(Object bar);
}

class MyBeanImpl implements MyRemoteInterface {
    @Override
    public void foo(Object bar) { 
        System.out.println(bar);
    }

    public void dangerousMethodThatMustNotBeInvoked() {
        // launch missiles
    }
}

public static void main(String[] args) {
    MyBeanImpl beanImpl = new MyBeanImpl();
    MyRemoteInterface remotableBean = restrictToInterface(beanImpl, MyRemoteInterface.class);
    System.out.println("Remoteable Methods are:");
    for (Method m : remotableBean.getClass().getMethods()) {
        if (!Modifier.isStatic(m.getModifiers())) {
            System.out.println("\t" + m.getName());
        }
    }

    remotableBean.foo("Hello world!");
}