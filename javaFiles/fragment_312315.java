<bean id="foo" class="java.lang.String">
    <constructor-arg value="#{containsObject('bar') ? bar : 'foo'}" />
</bean>

<bean id="bar" class="java.lang.String">
    <constructor-arg value="bar" />
</bean>