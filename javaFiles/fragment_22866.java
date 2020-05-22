<bean id="jmsClientFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
    <property name="brokerURL">
      <value>http://myendpoint.somewhere.com:5186?proxyUser=fred&amp;proxyPassword=ahoy&amp;proxyHost=myproxyhost.somewhere.com&amp;proxyPort=8081</value>
    </property>
</bean>


<bean id="remotingService"
        class="org.springframework.jms.remoting.JmsInvokerProxyFactoryBean">
      <property name="serviceInterface" value="com.foo.CheckingAccountService"/>
      <property name="connectionFactory" ref="jmsClientFactory"/>
      <property name="queue" ref="queue"/>
   </bean>