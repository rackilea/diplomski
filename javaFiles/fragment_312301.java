abstract class Parent implements BeanNameAware {

    String beanName;

    void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    abstract void doFilter();

}

@Component
class Child1 extends Parent {
    @Override
    void doFilter() {
        // some impl 
    }
}

@Component
class Child2 extends Parent {
    @Override
    void doFilter() {
        // some impl 
    }
}