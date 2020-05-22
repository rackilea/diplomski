<beans profile="development">
 <bean id="student" class="com.Student">
    <property name="name" value="${name}"/>
    <property name="id" value="123"/>
 </bean>
</beans>

<beans profile="production">
 <bean id="student" class="com.Student">
    <property name="name" value="${name}"/>
    <property name="id" value="#{idProvider.getId()}"/>
 </bean>
</beans>