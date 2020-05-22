public class CustomBean {
    private String value;

    public String getValue() {
        throw new NullPointerException();
    }
    public void setValue(String value) {
        this.value = value;
    }
}

@Component
public class MyComponent {
    private static final String a = "";
    @Value("#{customBean.value}")
    public String value;
}

<context:component-scan base-package="com.spring"></context:component-scan>
<context:property-placeholder location="classpath:values.properties"/> 
<bean id="customBean" class="com.spring.CustomBean" >
    <property name="value" value="bomb"></property>
</bean>