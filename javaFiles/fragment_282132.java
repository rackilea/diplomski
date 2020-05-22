<!-- Creation of the bean for the interceptor -->
<bean id="timeoutSetter" class="com.package.CustomTimeoutInterceptor">
  <property name="receiveTimeoutByOperationName">
    <map key-type="javax.xml.namespace.QName" value-type="java.lang.Long">
      <entry value="20000">
        <key>
          <bean class="javax.xml.namespace.QName" factory-method="valueOf">
            <constructor-arg value="{http://serveraddress/Service}Operation1" />
          </bean>
        </key>
      </entry>
    </map>
  </property>
</bean>

<!-- I had the interceptor the list of outInterceptors -->
<cxf:bus>
    <cxf:outInterceptors>
      <ref bean="timeoutSetter"/>
    </cxf:outInterceptors>
</cxf:bus>