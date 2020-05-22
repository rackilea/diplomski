@Bean
public String endpoint() {
    return "jdbc" + "a" + "b" + "c";
}

<bean id="SessionFactory" class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean"
      parent="AbstractSessionFactory">
    <property name="hibernateProperties">
        <map>
            <entry>
                <key>
                    <value>hibernate.connection.url</value>
                </key>
                <ref bean="endpoint"/>
            </entry>            
        </map>
    </property>
</bean>