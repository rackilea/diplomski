<bean class="org.apache.ignite.configuration.IgniteConfiguration">
  <property name="dataStorageConfiguration">
    <bean class="org.apache.ignite.configuration.DataStorageConfiguration">
      <property name="dataRegionConfigurations">
          <bean class="org.apache.ignite.configuration.DataRegionConfiguration">
            <property name="maxSize" value="#{45L * 1024 * 1024}"/>
            <property name="persistenceEnabled" value="true"/>
            <property name="name" value="cold"/> 
          </bean>
      </property>
    </bean>
  </property>
</bean>