<bean id="DsdDetectorLogic" class="my class" init-method="init" lazy-init="true" >
    <property name="threshold" value="#{ properties.threshold }" />
    <property name="lag" value="#{ (1 > new Integer(properties.lag ) or 
                                    new Integer(properties.lag ) > 3) ? 1 : 
                                    properties.lag  }" />
    ...
</bean>