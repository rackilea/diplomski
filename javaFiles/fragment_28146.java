<bean class="org.springframework.web.context.suppor.ServletContextAttributeExporter">
    <property name="attributes">
        <map>
            <entry key="env" value="#{environment['app/env']}" />
        </map>
    </properties>
</bean>