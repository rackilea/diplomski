<bean id="threadPoolExector" class="java.util.concurrent.ThreadPoolExecutor" lazy-init="true" scope="singleton">
    <constructor-arg index="0" type="int" value="${corePoolSize}"/>
    <constructor-arg index="1" type="int" value="${maximumPoolSize}"/>
    <constructor-arg index="2" type="long" value="${keepAliveTime}"/>
    <constructor-arg index="3" type="java.util.concurrent.TimeUnit" value="java.util.concurrent.TimeUnit.SECONDS"/>
    <constructor-arg index="4"  ref="abcBlockingQueueImpl"/>
</bean>