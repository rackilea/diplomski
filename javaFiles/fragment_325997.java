public class MyValidator {}

public class ValidatorHolder {
    private MyValidator myValidator;
    public void setMyValidator(MyValidator myValidator){
        this.myValidator = myValidator;}
    public MyValidator getMyValidator();
}

<bean class="com.somepackage.MyValidator" scope="prototype" />
<bean class="com.somepackage.ValidatorHolder">
    <aop:scoped-proxy />
</bean>