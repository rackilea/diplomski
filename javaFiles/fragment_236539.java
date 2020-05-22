<beans:bean id="jndiTemplate" class="org.springframework.jndi.JndiTemplate">
    <beans:property name="environment">
        <beans:props>
            <beans:prop key="java.naming.factory.initial">${jms.jndiFactory}</beans:prop>
            <beans:prop key="java.naming.provider.url">${jms.connectionUrl}</beans:prop>
            <beans:prop key="java.naming.security.principal">${jms.username}</beans:prop>
            <beans:prop key="java.naming.security.credentials">${jms.password}</beans:prop>
        </beans:props>
    </beans:property>
</beans:bean>

<beans:bean id="connectionFactory" class="org.springframework.jndi.JndiObjectFactoryBean">
    <beans:property name="jndiTemplate" ref="jndiTemplate" />
    <beans:property name="jndiName" value="${jms.connectionFactoryName}" />
</beans:bean>

<beans:bean id="connectionFactoryAdapter" class="com.company.jms.publisher.UserCredentialsConnectionFactoryAdapter">
    <beans:property name="jndiTemplate" ref="jndiTemplate" />
    <beans:property name="targetConnectionFactory" ref="connectionFactory" />
    <beans:property name="username" value="${jms.username}" />
    <beans:property name="password" value="${jms.password}" />
</beans:bean>

<beans:bean id="cachingConnectionFactory" class="org.springframework.jms.connection.CachingConnectionFactory">
    <beans:property name="targetConnectionFactory" ref="connectionFactoryAdapter" />
    <beans:property name="sessionCacheSize" value="10" />
</beans:bean>

<beans:bean id="destinationResolver" class="org.springframework.jms.support.destination.JndiDestinationResolver">
    <beans:property name="jndiTemplate" ref="jndiTemplate" />
</beans:bean>

<beans:bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
    <beans:property name="connectionFactory" ref="cachingConnectionFactory" />
    <beans:property name="destinationResolver" ref="destinationResolver" />
    <beans:property name="defaultDestinationName" value="${jms.publish.destinationName}" />

    <beans:property name="sessionAcknowledgeModeName" value="AUTO_ACKNOWLEDGE" />
    <beans:property name="sessionTransacted" value="false" />
</beans:bean>