<bean name="myBean" class="MyClass">
   <constructor-arg>
      <bean class="org.springframework.util.StringUtils" factory-method="commaDelimitedListToSet">
          <constructor-arg type="java.lang.String" value="${list.value}"/>
      </bean>
    </constructor-arg>
</bean>