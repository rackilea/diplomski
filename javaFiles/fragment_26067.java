<!-- RECEIVER -->
<bean id="connectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory" p:brokerURL="${jms.primary.server}"/>

<bean id="messageListener" class="com.ucware.ucpo.forward.jms.ProductMessageListener"/>

<jms:listener-container connection-factory="connectionFactory" concurrency="2" acknowledge="auto">
    <jms:listener destination="FORWARD" ref="messageListener" method="onMessage"/>
</jms:listener-container>

 <!-- SENDER -->

<!-- A cached connection to wrap the ActiveMQ connection --> 

<bean id="cachedConnectionFactory" 
     class="org.springframework.jms.connection.CachingConnectionFactory" 
     p:targetConnectionFactory-ref="connectionFactory"      
     p:sessionCacheSize="10" />

<!-- A destination in ActiveMQ --> 

<bean id="destination" 
    class="org.apache.activemq.command.ActiveMQQueue">
<constructor-arg value="FORWARD" />
</bean>

<!-- A JmsTemplate instance that uses the cached connection and destination --> 

<bean id="producerTemplate" 
    class="org.springframework.jms.core.JmsTemplate" 
    p:connectionFactory-ref="cachedConnectionFactory"
    p:defaultDestination-ref="destination" />
</beans>