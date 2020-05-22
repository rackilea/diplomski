<bean id="DiameterClient" class="com.rory.ptspsim.diameterclient.DiameterClient" init-method="start">
    <constructor-arg value="${pcca.host}" />
    <constructor-arg>
        <list>
            <ref bean="aarHandler" />
            ...
        </list>
    </constructor-arg>      
</bean>

<bean id="aarHandler" class="com.rory.ptspsim.diameterclient.AARHandler" />