interface MyBean {
    foo();
    bar();
}

@Component("my_bean")
class MyBeanImpl implements MyBean {
    public void foo() {
        System.out.println("foo");
        bar();
    }
    public void bar() {
        System.out.println("bar");
    }
}