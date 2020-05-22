<bean id="messageSource"
    class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
    <property name="basename">
        <value>${content.path.config}/WEB-INF/messages</value>
    </property>
    <property name="defaultEncoding" value="UTF-8" />
    <property name="cacheSeconds" value="2"/>
</bean>