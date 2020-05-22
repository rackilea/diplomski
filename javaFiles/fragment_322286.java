<bean id="abstractController" abstract = "true"
        class="com.test.controller.AbstractController">
    <property name="connectionTimeout" value="${rest.connectionTimeout}" />
</bean>

<bean id="testController" class="com.test.controller.testController"
        parent="abstractController">
   <!-- other properties but not connection timeout already inherited from parent -->
</bean>