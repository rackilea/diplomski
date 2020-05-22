<bean id="resellerValidator" class="org.springmodules.validation.valang.ValangValidator">
    <property name="valang">
        <value>
        <![CDATA[
            {resellerId: ? IS BLANK OR isValidResellerId(?) IS TRUE : '' : 'field.badFormat'}
        ]]>
        </value>
    </property>
</bean>

<bean id="isValidResellerId"
      class="org.springmodules.validation.valang.functions.FunctionWrapper"
      scope="prototype">
    <aop:scoped-proxy/>
    <property name="function">
        <bean id="isValidResellerIdFunction"
              class="com.myproject.valang.IsValidResellerIdFunction"
              scope="prototype">
            <property name="resellerService" ref="resellerService"/>
        </bean>
    </property>
</bean>