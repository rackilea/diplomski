<spring:bean id="MQConnectionFactory" class="com.ibm.mq.jms.MQQueueConnectionFactory">
           <spring:property name="hostName" value="${hostName}"/>
           <spring:property name="port" value="${port}"/>
           <spring:property name="channel" value="${channel}"/>
           <spring:property name="queueManager" value="${queueManager}"/>
           <spring:property name="SSLCipherSuite" value="${SSLCipherSuite}"/>
           <spring:property name="targetClientMatching" value="true" />
           <spring:property name="transportType" value="1" />
        </spring:bean>