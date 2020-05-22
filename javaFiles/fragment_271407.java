<bean id="mqConnectionFactory" class="com.ibm.mq.jms.MQQueueConnectionFactory">
    <property name="hostName" value="${queue_hostname}"/>
    <property name="port" value="${queue_port}"/>
    <property name="queueManager" value="${queue_manager}"/>
    <property name="transportType" value="1"/>
    <property name="SSLCipherSuite" value="SSL_RSA_EXPORT_WITH_RC4_40_MD5"/>
    <property name="channel" value="ssl_channel"/>
</bean>