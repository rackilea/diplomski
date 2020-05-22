<bean id="propertyManager"
 class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="locations">
       <list>
          <value>classpath:com/company/default.properties.${runtime.env}</value>
          <value>file:${COMPANY_PROPERTIES_LOCATION}\kbo-select-settings.properties</value>
        </list>
    </property>
 </bean>