<bean id="rawConnectionFactory1" class="org.apache.activemq.ActiveMQConnectionFactory">
    <property name="brokerURL" value="${broker.url}" />
    <property name="redeliveryPolicy" ref="policy1" />
    <property name="useCompression" value="true" />
</bean>
<bean id="rawConnectionFactory2" class="org.apache.activemq.ActiveMQConnectionFactory">
    <property name="brokerURL" value="${broker.url}" />
    <property name="redeliveryPolicy" ref="policy2" />
    <property name="useCompression" value="true" />
</bean>


<bean id="policy1" class="org.apache.activemq.RedeliveryPolicy">
    <property name="initialRedeliveryDelay" value="20000" />
    <property name="useExponentialBackOff" value="false" />
    <property name="useCollisionAvoidance" value="false" />
    <property name="maximumRedeliveries" value="0" />
</bean>
<bean id="policy2" class="org.apache.activemq.RedeliveryPolicy">
    <property name="initialRedeliveryDelay" value="60000" />
    <property name="useExponentialBackOff" value="false" />
    <property name="useCollisionAvoidance" value="false" />
    <property name="maximumRedeliveries" value="5" />
</bean>


<bean id="connectionFactory1" class="org.springframework.jms.connection.CachingConnectionFactory">
    <property name="targetConnectionFactory" ref="rawConnectionFactory1" />
    <property name="sessionCacheSize" value="30" />
</bean>
<bean id="connectionFactory2" class="org.springframework.jms.connection.CachingConnectionFactory">
    <property name="targetConnectionFactory" ref="rawConnectionFactory2" />
    <property name="sessionCacheSize" value="10" />
</bean>