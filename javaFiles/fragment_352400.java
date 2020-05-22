<bean id="bridgePropertyPlaceholder" class="org.apache.camel.spring.spi.BridgePropertyPlaceholderConfigurer">
    <property name="locations">
        <list>
            <value>${BROKER_CONF}</value>
        </list>
    </property>   
</bean>